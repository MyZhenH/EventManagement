package com.example.EventManagement.dto;

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
 * <p>The eventStatus is now a String (status name) instead of an EventStatus object to avoid
 * serialization issues with lazy loading.</p>
 */
public class EventDetailedDto {

    private Long eventId;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String address;
    private CityDto city;
    private EventStatusInfoDto eventStatus;
    //private String eventStatus;  // Changed from EventStatus object to String

    public EventDetailedDto() {}

    public EventDetailedDto(Long eventId, String title, String description,
                            LocalDateTime startDate, LocalDateTime endDate, String location,
                            String address, CityDto city, EventStatusInfoDto eventStatus) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.address = address;
        this.city = city;
        this.eventStatus = eventStatus;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public EventStatusInfoDto getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatusInfoDto eventStatus) {
        this.eventStatus = eventStatus;
    }
}