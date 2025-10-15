package com.example.EventManagement.controller;

import com.example.EventManagement.payload.EventRequestDto;
import com.example.EventManagement.payload.EventResponseDto;
import com.example.EventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventRequestDto eventRequestDto) {
        return ResponseEntity.ok(eventService.createEvent(eventRequestDto));
    }
}
