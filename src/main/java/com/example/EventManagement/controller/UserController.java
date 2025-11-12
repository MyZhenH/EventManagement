package com.example.EventManagement.controller;

import com.example.EventManagement.dto.UserUpcomingEventDto;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.payload.request.UserRegistrationDto;
import com.example.EventManagement.payload.response.ApiResponseWrapper;
import com.example.EventManagement.payload.response.ApiResponseWrapperEvent;
import com.example.EventManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.EventManagement.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository= userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponseWrapper<User>> registerNewUser(
            @Valid @RequestBody UserRegistrationDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            // Collect validation errors into a message string or list
            String errorMessage = result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));

            ApiResponseWrapper<User> errorResponse = ApiResponseWrapper.error(errorMessage);

            return ResponseEntity.badRequest().body(errorResponse);
        }

        ApiResponseWrapper<User> response = userService.registerNewUser(userDto);

        if ("success".equalsIgnoreCase(response.getStatus())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    /**
     * This end point fetches the upcoming events for a given user.
     * Logic explanation:
     * - We only consider events that the user is registered for .(e.g., "Confirmed")
     * - shows events whose start date is in the future (startDate >= CURRENT_TIMESTAMP).
     * Result:
     * - If the user is registered only for past events, the response will be empty.
     * - If the user is not registered for any events at all, the response will also be empty.
     * This is why some users (e.g., User 1) may see "No upcoming events" even though they are registered
     * for events in the past date.
     */

    @GetMapping("/upcoming-events")
    public ResponseEntity<ApiResponseWrapperEvent<List<UserUpcomingEventDto>>> getUserUpcomingEvents(
            Authentication authentication) {

        // Get user email from Auth0 token
        String email = authentication.getName();

        // Look up the user in  local DB
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // Get upcoming events for this user
        List<UserUpcomingEventDto> events = userService.getUpcomingEventsForUser(user.getUserId ());

        if (events.isEmpty()) {
            return ResponseEntity.ok(
                    new ApiResponseWrapperEvent<>("success", "No upcoming events.", Collections.emptyList())
            );
        }

        return ResponseEntity.ok(
                new ApiResponseWrapperEvent<>("success", "Upcoming events retrieved successfully.", events)
        );

    }
    /**
     * This endpoint unregisters a user from a specific event.
     * Logic explanation:
     * - First, it checks if the user is registered for the event and has a participant status other than "Cancelled".
     *   - If not registered, it throws a ResponseStatusException (a relevant message and status).
     * - Then, it fetches the "Cancelled" status from the ParticipantStatus table to assign and update to unregister.
     *   - If the "Cancelled" status is missing, it throws a ResponseStatusException.
     * - Updates the EventParticipant entity to set the participant status to "Cancelled".
     * - Saves the updated entity in the database.
     * Result:
     * - If successful, the user’s participation in the event is marked as cancelled.
     * - If the user was not registered, the response will indicate an error.
     * - This ensures that users cannot unregister from events they are not registered for.
     */

        @PostMapping("/unregister/{eventId}")
        public ResponseEntity<ApiResponseWrapperEvent<String>> unregisterFromEvent (
                @PathVariable Long eventId,
                Authentication authentication){

            // Extract email from Auth0 token
            String email = authentication.getName();

            // Look up user by email
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

            // Perform unregistration
            ApiResponseWrapperEvent<String> response = userService.unregisterUserFromEvent(user.getUserId(), eventId);

            return ResponseEntity.ok(response);
        }
}






