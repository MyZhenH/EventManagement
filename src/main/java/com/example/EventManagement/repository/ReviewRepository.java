package com.example.EventManagement.repository;

import com.example.EventManagement.entity.Event;
import com.example.EventManagement.entity.Review;
import com.example.EventManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Event> findByEventId(Long eventId);
    List<User> findByUserId(Long userId);

}
