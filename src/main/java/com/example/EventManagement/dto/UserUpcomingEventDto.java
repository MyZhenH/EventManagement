package com.example.EventManagement.dto;



import java.time.LocalDateTime;

public class UserUpcomingEventDto {
    private Long eventId;
    private String title;
    private String location;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;

    public UserUpcomingEventDto(Long eventId, String title, String location, String description,
                                LocalDateTime startDate, LocalDateTime endDate, String status) {
        this.eventId = eventId;
        this.title = title;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
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

