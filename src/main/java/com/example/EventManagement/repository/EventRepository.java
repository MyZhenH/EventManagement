package com.example.EventManagement.repository;

import com.example.EventManagement.entity.Category;
import com.example.EventManagement.entity.Event;
import com.example.EventManagement.entity.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {

    List<Event> findByTitleContainingIgnoreCase(String title);
    List<Event> findByLocationContainingIgnoreCase(String location);
    List<Event> findByCategoryContainingIgnoreCase(String category);
    List<Category> findByCategoryId(Long categoryId);
    List<EventStatus> findByEventStatusId(Long eventStatusId);


}
