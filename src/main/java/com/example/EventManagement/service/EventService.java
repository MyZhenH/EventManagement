package com.example.EventManagement.service;

import com.example.EventManagement.dto.EventBasicDto;
import com.example.EventManagement.dto.EventDetailedDto;
import com.example.EventManagement.dto.EventStatusDto;
import com.example.EventManagement.entity.Category;
import com.example.EventManagement.entity.Event;
import com.example.EventManagement.entity.EventStatus;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.payload.request.EventCreateRequest;
import com.example.EventManagement.payload.request.EventUpdateRequest;
import com.example.EventManagement.payload.response.EventResponseDto;
import com.example.EventManagement.repository.CategoryRepository;
import com.example.EventManagement.repository.EventRepository;
import com.example.EventManagement.repository.EventStatusRepository;
import com.example.EventManagement.repository.UserRepository;
import com.example.EventManagement.mapper.EventMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {


    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final EventStatusRepository eventStatusRepository;
    private final EventMapper eventMapper;


    public EventService(EventRepository eventRepository,
                        UserRepository userRepository,
                        CategoryRepository categoryRepository,
                        EventStatusRepository eventStatusRepository, EventMapper eventMapper) {

        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.eventStatusRepository = eventStatusRepository;
        this.eventMapper = eventMapper;

    }

    public List<EventBasicDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toBasicDtoList(events);
    }


    public EventDetailedDto getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id " + eventId));
        return eventMapper.toDetailedDto(event);
    }
  
    public EventResponseDto createEvent(EventCreateRequest eventCreateRequest) {
        User user = userRepository.findById(1L).orElse(null);
        Event savedEvent = eventRepository.save(toEventEntity(eventCreateRequest, user));
        return toEventResponseDto(savedEvent);
    }

    public EventResponseDto updateEvent(Long eventId, EventUpdateRequest eventUpdateRequest) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        if (eventUpdateRequest.title() != null) {
            event.setTitle(eventUpdateRequest.title());
        }

        if (eventUpdateRequest.description() != null) {
            event.setDescription(eventUpdateRequest.description());
        }

        if (eventUpdateRequest.startDate() != null) {
            event.setStartDate(eventUpdateRequest.startDate());
        }

        if (eventUpdateRequest.endDate() != null) {
            event.setStartDate(eventUpdateRequest.endDate());
        }

        if (eventUpdateRequest.location() != null) {
            event.setLocation(eventUpdateRequest.location());
        }

        if (eventUpdateRequest.categoryId() != null) {
            Category category = categoryRepository.findById(eventUpdateRequest.categoryId())
                    .orElseThrow(() -> new EntityNotFoundException("Category not found"));
            event.setCategory(category);
        }

        if (eventUpdateRequest.eventStatusId() != null) {
            EventStatus eventStatus = eventStatusRepository.findById(eventUpdateRequest.eventStatusId())
                    .orElseThrow(() -> new EntityNotFoundException("Event status not found"));
            event.setEventStatus(eventStatus);
        }

        // 1L is a placeholder during dev
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Event savedEvent = eventRepository.save(event);
        return toEventResponseDto(savedEvent);
    }

    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new EntityNotFoundException("Event not found");
        }

        eventRepository.deleteById(id);
    }

    private EventResponseDto toEventResponseDto(Event event) {
        return new EventResponseDto(
                event.getEventId(),
                event.getTitle(),
                event.getDescription(),
                event.getStartDate(),
                event.getEndDate(),
                event.getLocation(),
                event.getCreatedAt(),
                event.getUpdatedAt(),
                event.getCreatedBy().getUserId(),
                event.getUpdatedBy().getUserId(),
                event.getCategory().getCategoryId(),
                event.getEventStatus().getEventStatusId()
        );
    }

    private Event toEventEntity(EventCreateRequest dto, User user) {
        Category category = getCategory(dto.categoryId());
        EventStatus status = getEventStatus(dto.eventStatusId());

        Event event = new Event();

        event.setTitle(dto.title());
        event.setDescription(dto.description());
        event.setStartDate(dto.startDate());
        event.setEndDate(dto.endDate());
        event.setLocation(dto.location());
        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());

        // This will be changed later to admin functionality
        event.setCreatedBy(user);
        event.setUpdatedBy(user);

        return event;
    }

    private Category getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    private EventStatus getEventStatus(Long id) {
        return eventStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event status not found"));
    }

    public EventStatusDto newEventStatusAndMap(Long eventId, Long newStatusId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        EventStatus newStatus = eventStatusRepository.findById(newStatusId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status not found"));

        event.setEventStatus(newStatus);
        Event updated = eventRepository.save(event);

        // To resolve problem with load lazy fields
        updated.getCreatedBy().getFirstName();
        updated.getCategory().getCategoryName();
        updated.getEventStatus().getStatusName();

        return new EventStatusDto(updated);
    }
}
