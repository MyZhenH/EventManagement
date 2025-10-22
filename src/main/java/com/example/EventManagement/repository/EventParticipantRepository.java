package com.example.EventManagement.repository;

import com.example.EventManagement.entity.Event;
import com.example.EventManagement.entity.EventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventParticipantRepository extends JpaRepository <EventParticipant, Long> {
    List<EventParticipant> findByEvent_EventId(Long eventId);
    List<EventParticipant> findByUser_UserId(Long userId);
    List<EventParticipant> findByParticipantStatus_PStatusId(Long pStatusId);
//    @Query("SELECT ep.event FROM EventParticipant ep " +
//            "WHERE ep.user.userId = :userId " +
//            "AND ep.participantStatus.pStatusId = :statusId " +
//            "AND ep.event.eventDate >= CURRENT_TIMESTAMP")
//    List<Event> findUpcomingEventsByUserAndStatus(@Param("userId") Long userId,
//                                                  @Param("statusId") Long statusId);
@Query("SELECT ep FROM EventParticipant ep " +
        "WHERE ep.user.userId = :userId " +
        "AND ep.participantStatus.pStatusId = :statusId " +
        "AND ep.event.eventDate >= CURRENT_TIMESTAMP")
List<EventParticipant> findUpcomingEventParticipantsByUserAndStatus(@Param("userId") Long userId,
                                                                    @Param("statusId") Long statusId);


}
