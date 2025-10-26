package com.example.EventManagement.dto;

import com.example.EventManagement.entity.EventStatus;
import com.example.EventManagement.utils.DateUtils;

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
    private String eventDate;
    private String location;
    private String eventStatus;
    private String address;
    private String city;

    public EventDetailedDto() {
    }

    public EventDetailedDto(String title, String description, LocalDateTime startDate,
                            LocalDateTime endDate, String location, String address, String city, String eventStatus) {

        this.title = title;
        this.description = description;
        this.eventDate = DateUtils.formatEventDate(startDate, endDate);
        this.location = location;
        this.address = address;
        this.city = city;
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

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime startDate, LocalDateTime endDate) {
        this.eventDate = DateUtils.formatEventDate(startDate, endDate);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
