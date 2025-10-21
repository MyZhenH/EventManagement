package com.example.EventManagement.repository;

import com.example.EventManagement.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    boolean existsById(@NonNull Long id);

    List<Event> findByTitleContainingIgnoreCase(String title);
    List<Event> findByLocationContainingIgnoreCase(String location);
    List<Event> findByCategory_CategoryNameContainingIgnoreCase(String categoryName);
    List<Event> findByCategory_CategoryId(Long categoryId);
    List<Event> findByEventStatus_EventStatusId(Long eventStatusId);
    @Query("SELECT e FROM Event e WHERE e.eventStatus.statusName = :statusName")
    Optional<Event> findByStatusName(@Param("statusName") String statusName);

}
