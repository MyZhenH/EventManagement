package com.example.EventManagement.dto;

import com.example.EventManagement.utils.DateUtils;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for representing an event.
 * This DTO is used for transferring detailed event data such as title, location, event date, description and event status.
 */
public class EventDetailedDTO {
    private String title;
    private String location;
    private String eventDate;
    private String description;
    private String eventStatus;

    public EventDetailedDTO() {
    }

    public EventDetailedDTO(String title, String location, LocalDateTime eventDate,
                            String description, String eventStatus) {
        this.title = title;
        this.location = location;
        this.eventDate = DateUtils.formatEventDate(eventDate);
        this.description = description;
        this.eventStatus = eventStatus;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

}
