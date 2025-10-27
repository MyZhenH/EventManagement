package com.example.EventManagement.repository;

import com.example.EventManagement.entity.Event;
import com.example.EventManagement.entity.EventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventParticipantRepository extends JpaRepository <EventParticipant, Long> {
    List<EventParticipant> findByEvent_EventId(Long eventId);
    List<EventParticipant> findByUser_UserId(Long userId);
    List<EventParticipant> findByParticipantStatus_PStatusId(Long pStatusId);

@Query("SELECT ep FROM EventParticipant ep " +
        "WHERE ep.user.userId = :userId " +
        "AND ep.participantStatus.statusName <> 'Cancelled' " +
        "AND ep.event.startDate >= CURRENT_TIMESTAMP " +
        "ORDER BY ep.event.startDate ASC")
List<EventParticipant> findUpcomingEventParticipants(@Param("userId") Long userId);

Optional<EventParticipant> findByUserUserIdAndEventEventId(Long userId, Long eventId);
}
