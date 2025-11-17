package com.example.EventManagement.controller;

import com.example.EventManagement.dto.MyEventDto;
import com.example.EventManagement.service.ParticipantService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    /**
     * Register user for an event
     */
    @PostMapping("/register/{eventId}")
    public ResponseEntity<Map<String, Object>> registerForEvent(
            @PathVariable Long eventId,
            HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "You must be logged in to register for events");
            return ResponseEntity.status(401).body(response);
        }

        try {
            boolean success = participantService.registerForEvent(userId, eventId);

            Map<String, Object> response = new HashMap<>();
            response.put("success", success);
            response.put("message", success ? "Successfully registered for event!" : "Could not register for event");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * Unregister user from an event
     */
    @DeleteMapping("/unregister/{eventId}")
    public ResponseEntity<Map<String, Object>> unregisterFromEvent(
            @PathVariable Long eventId,
            HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "You must be logged in");
            return ResponseEntity.status(401).body(response);
        }

        try {
            boolean success = participantService.unregisterFromEvent(userId, eventId);

            Map<String, Object> response = new HashMap<>();
            response.put("success", success);
            response.put("message", success ? "Successfully unregistered from event" : "Could not unregister");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * Check if user is registered for an event
     */
    @GetMapping("/check/{eventId}")
    public ResponseEntity<Map<String, Boolean>> checkRegistration(
            @PathVariable Long eventId,
            HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        Map<String, Boolean> response = new HashMap<>();

        if (userId == null) {
            response.put("registered", false);
            return ResponseEntity.ok(response);
        }

        boolean isRegistered = participantService.isUserRegistered(userId, eventId);
        response.put("registered", isRegistered);

        return ResponseEntity.ok(response);
    }

    /**
     * Get all events the user is registered for
     */
    @GetMapping("/my-events")
    public ResponseEntity<List<MyEventDto>> getMyEvents(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.status(401).build();
        }

        List<MyEventDto> myEvents = participantService.getMyEvents(userId);
        return ResponseEntity.ok(myEvents);
    }
}