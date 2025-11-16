package com.example.EventManagement.dto;

import java.time.LocalDateTime;

public class EventDetailedDto extends EventBasicDto {

    private String description;
    private String address;
    private Long eventStatusId;
    private String eventStatus;  // Changed from EventStatus object to String

    public EventDetailedDto() {}

    public EventDetailedDto(Long eventId, String title, String location,
                            LocalDateTime startDate, LocalDateTime endDate, CityDto city,
                            Long categoryId, String categoryName, String description,
                            String address, Long eventStatusId, String eventStatus) {
        super(eventId, title, location, startDate, endDate, city, categoryId, categoryName);
        this.description = description;
        this.address = address;
        this.eventStatusId = eventStatusId;
        this.eventStatus = eventStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getEventStatusId() {
        return eventStatusId;
    }

    public void setEventStatusId(Long eventStatusId) {
        this.eventStatusId = eventStatusId;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }
}