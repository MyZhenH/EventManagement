package com.example.EventManagement.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.example.EventManagement.entity.Event;

import java.time.LocalDateTime;

//public class UserUpcomingEventDto {
//    private Long eventId;
//    private String title;
//    private String location;
//    private LocalDateTime eventDate;
//    private String description;
//    private String status;
//
//    public UserUpcomingEventDto(Event event) {
//        this.eventId = event.getEventId();
//        this.title = event.getTitle();
//        this.location = event.getLocation();
//        this.eventDate = event.getEventDate();
//        this.description = event.getDescription();
//        this.status = event.getEventStatus().getStatusName();
//    }
//
//    public Long getEventId() {
//        return eventId;
//    }
//
//    public void setEventId(Long eventId) {
//        this.eventId = eventId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public LocalDateTime getEventDate() {
//        return eventDate;
//    }
//
//    public void setEventDate(LocalDateTime eventDate) {
//        this.eventDate = eventDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class UserUpcomingEventDto {

    @JsonProperty("id")
    private Long eventId;

    private String title;
    private String location;

    @JsonProperty("eventDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;

    @JsonProperty("start")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @JsonProperty("end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    private String description;

    @JsonProperty("status")  // renamed from eventStatus
    private String eventStatus;

    @JsonProperty("participant")  // renamed from participantStatus
    private String participantStatus;

    public UserUpcomingEventDto(Event event, String participantStatus) {
        this.eventId = event.getEventId();
        this.title = event.getTitle();
        this.location = event.getLocation();

        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.description = event.getDescription();
        this.eventStatus = event.getEventStatus().getStatusName();
        this.participantStatus = participantStatus;
    }


}


