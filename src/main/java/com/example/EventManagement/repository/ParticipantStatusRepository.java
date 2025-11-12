package com.example.EventManagement.repository;

import com.example.EventManagement.entity.ParticipantStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantStatusRepository extends JpaRepository<ParticipantStatus, Long> {
    List<ParticipantStatus> findByStatusNameContainingIgnoreCase(String statusName);
    Optional<ParticipantStatus> findByStatusName(String statusName);
}
