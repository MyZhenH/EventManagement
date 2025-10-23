package com.example.EventManagement.dto;

import com.example.EventManagement.entity.EventStatus;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) representing detailed information about an event.
 *
 * <p>This DTO carries essential information for displaying or processing detailed event data,
 * including the event title, description, location, start and end dates, and the current event status.</p>
 *
 * <p>All date and time fields are represented as raw {@link java.time.LocalDateTime} objects,
 * without formatting, to keep this DTO focused on data transfer without presentation logic.</p>
 *
 * <p>The {@link EventStatus} enum captures the current state or status of the event.</p>
 *
 * <p>This DTO serves as a structured contract between application layers, facilitating clear
 * and safe data exchange without embedding business logic or formatting concerns.</p>
 */
public class EventDetailedDto {
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private EventStatus eventStatus;

    public EventDetailedDto() {}

    public EventDetailedDto(String title, String description, LocalDateTime startDate,
                            LocalDateTime endDate, String location, EventStatus eventStatus) {

        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.eventStatus = eventStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }
}
