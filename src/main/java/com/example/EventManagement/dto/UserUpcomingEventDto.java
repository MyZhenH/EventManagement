package com.example.EventManagement.dto;

import com.example.EventManagement.entity.Event;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class UserUpcomingEventDto {

    @JsonProperty("id")
    private Long eventId;

    private String title;
    private String location;
    private String description;

    @JsonProperty("start")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @JsonProperty("end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @JsonProperty("status")  //  event status
    private String status;

    public UserUpcomingEventDto() {
    }

    public UserUpcomingEventDto(Event event) {
        this.eventId = event.getEventId();
        this.title = event.getTitle();
        this.location = event.getLocation();
        this.description = event.getDescription();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.status = event.getEventStatus() != null
                ? event.getEventStatus().getStatusName()
                : null;

    }


    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    public String getEventStatus() { return status; }
    public void setEventStatus(String eventStatus) { this.status = eventStatus; }
}
