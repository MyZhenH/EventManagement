package com.example.EventManagement.repository;

import com.example.EventManagement.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByEvent_EventId(Long eventId);
    List<Review> findByUser_UserId(Long userId);

}
