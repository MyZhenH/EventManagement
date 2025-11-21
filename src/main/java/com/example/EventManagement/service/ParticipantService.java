package com.example.EventManagement.service;

import com.example.EventManagement.dto.MyEventDto;
import com.example.EventManagement.entity.Event;
import com.example.EventManagement.entity.EventParticipant;
import com.example.EventManagement.entity.ParticipantStatus;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.repository.EventParticipantRepository;
import com.example.EventManagement.repository.EventRepository;
import com.example.EventManagement.repository.ParticipantStatusRepository;
import com.example.EventManagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipantService {

    private final EventParticipantRepository eventParticipantRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final ParticipantStatusRepository participantStatusRepository;

    public ParticipantService(EventParticipantRepository eventParticipantRepository,
                              EventRepository eventRepository,
                              UserRepository userRepository,
                              ParticipantStatusRepository participantStatusRepository) {
        this.eventParticipantRepository = eventParticipantRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.participantStatusRepository = participantStatusRepository;
    }

    /**
     * Register a user for an event
     */
    @Transactional
    public boolean registerForEvent(Long userId, Long eventId) {
        // Check if user exists
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if event exists
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Check if user is already registered
        Optional<EventParticipant> existingRegistration = eventParticipantRepository
                .findByEvent_EventIdAndUser_UserId(eventId, userId);

        if (existingRegistration.isPresent()) {
            throw new RuntimeException("You are already registered for this event");
        }

        // Get "Confirmed" status (status_id = 1)
        ParticipantStatus confirmedStatus = participantStatusRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Participant status not found"));

        // Create new participant registration
        EventParticipant participant = new EventParticipant();
        participant.setEvent(event);
        participant.setUser(user);
        participant.setParticipantStatus(confirmedStatus);

        eventParticipantRepository.save(participant);

        System.out.println("✅ User " + userId + " registered for event " + eventId);
        return true;
    }

    /**
     * Unregister a user from an event
     */
    @Transactional
    public boolean unregisterFromEvent(Long userId, Long eventId) {
        Optional<EventParticipant> participantOpt = eventParticipantRepository
                .findByEvent_EventIdAndUser_UserId(eventId, userId);

        if (participantOpt.isEmpty()) {
            throw new RuntimeException("You are not registered for this event");
        }

        eventParticipantRepository.delete(participantOpt.get());

        System.out.println("✅ User " + userId + " unregistered from event " + eventId);
        return true;
    }

    /**
     * Check if user is registered for an event
     */
    public boolean isUserRegistered(Long userId, Long eventId) {
        return eventParticipantRepository
                .findByEvent_EventIdAndUser_UserId(eventId, userId)
                .isPresent();
    }

    /**
     * Get all events a user is registered for
     */
    @Transactional(readOnly = true)
    public List<MyEventDto> getMyEvents(Long userId) {
        List<EventParticipant> participants = eventParticipantRepository.findByUser_UserId(userId);

        return participants.stream()
                .map(participant -> {
                    Event event = participant.getEvent();

                    return new MyEventDto(
                            participant.getParticipantId(),
                            event.getEventId(),
                            event.getTitle(),
                            event.getStartDate(),
                            event.getLocation(),
                            participant.getParticipantStatus().getStatusName()
                    );
                })
                .collect(Collectors.toList());
    }
}