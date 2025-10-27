package com.example.EventManagement.controller;

import com.example.EventManagement.dto.UserUpcomingEventDto;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.payload.response.ApiResponseWrapper;
import com.example.EventManagement.payload.response.UserUpcomingEventsResponse;
import com.example.EventManagement.service.EventService;
import com.example.EventManagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {

    private final EventService eventService;
    private final UserService userService;



    public UserController(UserService userService,EventService eventService){
        this.userService = userService;
        this.eventService= eventService;
    }


    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        Map<String, String> response = userService.registerUser(user);
        if ("success".equals(response.get("status"))){
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
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
    public ResponseEntity<UserUpcomingEventsResponse> getUserUpcomingEvents(@PathVariable Long userId) {
        List<UserUpcomingEventDto> events = userService.getUpcomingEventsForUser(userId);

        if (events.isEmpty()) {
            return ResponseEntity.ok(
                    new UserUpcomingEventsResponse("No upcoming events .", Collections.emptyList())
            );
        }

        return ResponseEntity.ok(
                new UserUpcomingEventsResponse("coming events .", events)
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
    public ApiResponseWrapper<String> unregister(
            @PathVariable Long userId,
            @PathVariable Long eventId
    ) {
        return userService.unregisterUserFromEvent(userId, eventId);
    }
}
