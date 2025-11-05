package com.example.EventManagement.dto;


import java.time.LocalDateTime;

public class EventBasicDto {

    private Long eventId;
    private String title;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private CityDto city;

    public EventBasicDto() {}


    public EventBasicDto(Long eventId, String title, String location,
                         LocalDateTime startDate, LocalDateTime endDate, CityDto city) {
        this.eventId = eventId;
        this.title = title;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
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

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }
}
