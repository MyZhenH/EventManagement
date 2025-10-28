package com.example.EventManagement.dto;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) representing basic event data.
 *
 * This DTO is used to transfer essential event information between layers of the application,
 * such as event ID, title, location, and event start and end dates.
 *
 * It contains raw date/time data as {@link java.time.LocalDateTime} fields without formatting,
 * leaving presentation and formatting concerns to higher layers (e.g., UI or API).
 *
 * This separation ensures a clean architecture and allows flexible date formatting depending on context.
 */
public class EventBasicDto {

    private Long eventId;
    private String title;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public EventBasicDto() {}

    public EventBasicDto(Long eventId, String title, String location,
                         LocalDateTime startDate, LocalDateTime endDate) {

        this.eventId = eventId;
        this.title = title;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
