package com.example.EventManagement.dto;

import com.example.EventManagement.utils.DateUtils;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for representing an event.
 * This DTO is used for transferring basic event data such as title, location and event date.
 */
public class EventBasicDTO {
        private String title;
        private String location;
        private String eventDate;

    public EventBasicDTO() {
    }

    public EventBasicDTO(String title, String location, LocalDateTime eventDate) {
        this.title = title;
        this.location = location;
        this.eventDate = DateUtils.formatEventDate(eventDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = DateUtils.formatEventDate(eventDate);
    }
}
