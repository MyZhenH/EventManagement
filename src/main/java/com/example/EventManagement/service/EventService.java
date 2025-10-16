package com.example.EventManagement.service;


import com.example.EventManagement.dto.EventBasicDTO;
import com.example.EventManagement.dto.EventDetailedDTO;
import com.example.EventManagement.entity.Event;
import com.example.EventManagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;


    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Retrieves a list of all events with basic information (title, location, and event date).
     * <p>
     * This method fetches all events from the repository and converts them into {@link EventBasicDTO} objects.
     * The resulting list includes only the title, location, and event date of each event.
     * If the location or event date is not available, the method will default to "Not Determined" for location.
     * </p>
     *
     * @return A list of {@link EventBasicDTO} objects representing basic information about each event.
     * If there are no events in the repository, an empty list will be returned.
     */
    public List<EventBasicDTO> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(event -> new EventBasicDTO(
                        event.getTitle(),
                        event.getLocation() != null ? event.getLocation() : "Not Determined",
                        event.getEventDate()
                ))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves detailed information about an event based on the eventId.
     * <p>
     * This method looks up an event in the repository by its {@code eventId} and returns a detailed
     * representation of the event, including its title, location, event date, description, and event status.
     * If no event is found with the given ID, the method returns {@code null}.
     * </p>
     *
     * @return An {@link EventDetailedDTO} object containing detailed information about the event,
     * or {@code null} if no event is found with the provided ID.
     */
    public EventDetailedDTO getEventById(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);

        if (event.isPresent()) {
            return new EventDetailedDTO(
                    event.get().getTitle(),
                    event.get().getLocation() != null ? event.get().getLocation() : "Not Determined",
                    event.get().getEventDate(),
                    event.get().getDescription(),
                    event.get().getEventStatus().getStatusName());
        } else {
            return null;
        }
    }


}








