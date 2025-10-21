package com.example.EventManagement.controller;

import com.example.EventManagement.dto.UserUpcomingEventDto;
import com.example.EventManagement.payload.response.UserUpcomingEventsResponse;
import com.example.EventManagement.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final EventService eventService;

    public UserController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/{userId}/upcoming-events")
    public ResponseEntity<UserUpcomingEventsResponse> getUserUpcomingEvents(@PathVariable Long userId) {
        List<UserUpcomingEventDto> events = eventService.getUpcomingEventsForUser(userId);

        if (events.isEmpty()) {
            return ResponseEntity.ok(
                    new UserUpcomingEventsResponse("No upcoming events.", Collections.emptyList())
            );
        }

        return ResponseEntity.ok(
                new UserUpcomingEventsResponse("Upcoming events.", events)
        );
    }

}
