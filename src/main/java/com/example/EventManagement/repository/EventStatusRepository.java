package com.example.EventManagement.repository;

import com.example.EventManagement.entity.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventStatusRepository extends JpaRepository<EventStatus, Long> {
    List<EventStatus> findByStatusNameContainingIgnoreCase(String statusName);
}
