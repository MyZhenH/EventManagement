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

    /**
     * Retrieve a list of basic event information.
     * This method returns a list of events with basic details such as title, location, and event date.
     * If no events are found, it returns an HTTP status code 204 (No Content).
     *
     * @return a list of events containing basic event details,
     * or HTTP status 204 (No Content) if no events are found.
     */
    @GetMapping
    public ResponseEntity<List<EventBasicDto>> getAllEvents(){
        List<EventBasicDto> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    /**
     * Retrieve detailed information about an event based on the eventId.
     * This method returns detailed information about an event, including:
     * title, location, date, description, and event status. If the event is not
     * found, it returns an HTTP status code 404 (Not Found).
     *
     *  @param eventId The ID of the event to retrieve.
     *  @return The detailed information about the event if the event exists,
     *  otherwise returns HTTP status 404 (Not Found).
     */
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