package com.example.EventManagement.repository;

import com.example.EventManagement.entity.EventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventParticipantRepository extends JpaRepository <EventParticipant, Long> {
    List<EventParticipant> findByEvent_EventId(Long eventId);
    List<EventParticipant> findByUser_UserId(Long userId);
    List<EventParticipant> findByParticipantStatus_PStatusId(Long pStatusId);
    Optional<EventParticipant> findByEvent_EventIdAndUser_UserId(Long eventId, Long userId);
}