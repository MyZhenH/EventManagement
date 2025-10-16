package com.example.EventManagement.controller;

import com.example.EventManagement.dto.EventBasicDTO;
import com.example.EventManagement.dto.EventDetailedDTO;
import com.example.EventManagement.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<EventBasicDTO>> getAllEvents(){
        List<EventBasicDTO> events = eventService.getAllEvents();

        if(events.isEmpty()){
            return ResponseEntity.noContent().build();
        }
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
    public ResponseEntity<EventDetailedDTO> getEventById(@PathVariable Long eventId){
        EventDetailedDTO eventDTO = eventService.getEventById(eventId);

        if (eventDTO != null){
            return ResponseEntity.ok(eventDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
