package com.example.EventManagement.dto;

/**
 * Data Transfer Object (DTO) for representing an event.
 * This DTO is used for transferring basic event data such as event id, title, location and event date.
 */
public class EventBasicDto {
    private Long eventId;
    private String title;
    private String location;
    private String eventDate;

    public EventBasicDto() {}

    public EventBasicDto(Long eventId, String title, String location,
                         String eventDate) {

        this.eventId = eventId;
        this.title = title;
        this.location = location;
        this.eventDate = eventDate;
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

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}
