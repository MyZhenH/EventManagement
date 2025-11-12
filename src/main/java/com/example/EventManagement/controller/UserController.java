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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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


    @GetMapping("/{userId}/upcoming-events")
    public ResponseEntity<ApiResponseWrapperEvent<List<UserUpcomingEventDto>>> getUserUpcomingEvents(@PathVariable Long userId) {
        List<UserUpcomingEventDto> events = userService.getUpcomingEventsForUser(userId);

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

    @PostMapping("/{userId}/unregister/{eventId}")
    public ApiResponseWrapperEvent<String> unregister(
            @PathVariable Long userId,
            @PathVariable Long eventId
    ) {
        return userService.unregisterUserFromEvent(userId, eventId);
    }


}


