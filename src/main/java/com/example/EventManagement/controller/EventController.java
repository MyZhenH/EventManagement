package com.example.EventManagement.controller;

import com.example.EventManagement.dto.EventBasicDto;
import com.example.EventManagement.dto.EventDetailedDto;
import com.example.EventManagement.dto.EventStatusDto;
import com.example.EventManagement.payload.request.EventCreateRequest;
import com.example.EventManagement.payload.request.UpdateEventStatusRequest;
import com.example.EventManagement.payload.response.EventResponseDto;
import com.example.EventManagement.payload.request.EventUpdateRequest;
import com.example.EventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping
    public ResponseEntity<List<EventBasicDto>> getAllEvents(){
        List<EventBasicDto> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }


    @GetMapping("/{eventId}")
    public ResponseEntity<EventDetailedDto> getEventById(@PathVariable Long eventId){
        EventDetailedDto eventDTO = eventService.getEventById(eventId);
          return ResponseEntity.ok(eventDTO);

    }
  
    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventCreateRequest eventCreateRequest) {
        return ResponseEntity.ok(eventService.createEvent(eventCreateRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EventResponseDto> updateEvent(@PathVariable Long id,
                                                        @Valid @RequestBody EventUpdateRequest eventUpdateRequest) {

        EventResponseDto eventResponseDto = eventService.updateEvent(id, eventUpdateRequest);
        return ResponseEntity.ok(eventResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{eventId}/status")
    public ResponseEntity<EventStatusDto> updateEventStatus(
            @PathVariable Long eventId,
            @RequestBody UpdateEventStatusRequest request
    ) {
        EventStatusDto dto = eventService.newEventStatusAndMap(eventId, request.getEventStatusId());
        return ResponseEntity.ok(dto);
    }
}
