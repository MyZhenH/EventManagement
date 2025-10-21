package com.example.EventManagement.dto;

import com.example.EventManagement.entity.Event;

import java.time.LocalDateTime;

public class EventStatusDto {
    private Long eventId;
    private String title;
    private String description;
    private String location;
    private LocalDateTime eventDate;
    private String categoryName;
    private String createdByUsername;
    private String statusName;


    public EventStatusDto() {} //  for serialization


    public EventStatusDto(Event event) {
        this.eventId = event.getEventId();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.location = event.getLocation();
        this.eventDate = event.getEventDate();
        this.categoryName = event.getCategory().getCategoryName();
        this.createdByUsername = event.getCreatedBy().getFirstName();
        this.statusName = event.getEventStatus().getStatusName();
    }



    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }


    public LocalDateTime getEventDate() { return eventDate; }
    public void setEventDate(LocalDateTime eventDate) { this.eventDate = eventDate; }


    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }


    public String getCreatedByUsername() { return createdByUsername; }
    public void setCreatedByUsername(String createdByUsername) { this.createdByUsername = createdByUsername; }


    public String getStatusName() { return statusName; }
    public void setStatusName(String statusName) { this.statusName = statusName; }

}
