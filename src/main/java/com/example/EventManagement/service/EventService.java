package com.example.EventManagement.service;

import com.example.EventManagement.entity.Category;
import com.example.EventManagement.entity.Event;
import com.example.EventManagement.entity.EventStatus;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.payload.EventRequestDto;
import com.example.EventManagement.payload.EventResponseDto;
import com.example.EventManagement.repository.CategoryRepository;
import com.example.EventManagement.repository.EventRepository;
import com.example.EventManagement.repository.EventStatusRepository;
import com.example.EventManagement.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final EventStatusRepository eventStatusRepository;

    public EventService(EventRepository eventRepository,
                        UserRepository userRepository,
                        CategoryRepository categoryRepository,
                        EventStatusRepository eventStatusRepository) {

        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.eventStatusRepository = eventStatusRepository;
    }

    public EventResponseDto createEvent(EventRequestDto eventRequestDto) {
        User user = userRepository.findById(1L).orElse(null);
        Event savedEvent = eventRepository.save(toEventEntity(eventRequestDto, user));
        return toEventResponseDto(savedEvent);
    }

    private EventResponseDto toEventResponseDto(Event event) {
        return new EventResponseDto(
                event.getEventId(),
                event.getTitle(),
                event.getDescription(),
                event.getEventDate(),
                event.getLocation(),
                event.getCreatedAt(),
                event.getUpdatedAt(),
                event.getCreatedBy().getUserId(),
                event.getCategory().getCategoryId(),
                event.getEventStatus().getEventStatusId()
        );
    }

    private Event toEventEntity(EventRequestDto eventRequestDto, User createdBy) {
        Event event = new Event();

        event.setTitle(eventRequestDto.title());
        event.setDescription(eventRequestDto.description());
        event.setEventDate(eventRequestDto.eventDate());
        event.setLocation(eventRequestDto.location());
        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());

        // This will be changed later to admin functionality
        event.setCreatedBy(createdBy);

        Category category = categoryRepository.findById(eventRequestDto.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        event.setCategory(category);

        EventStatus eventStatus = eventStatusRepository.findById(eventRequestDto.eventStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Event status not found"));
        event.setEventStatus(eventStatus);

        return event;
    }
}
