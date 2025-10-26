package com.example.EventManagement.dto;

import com.example.EventManagement.utils.DateUtils;

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

    private String title;
    private String location;
    private String eventDate;
    private String city;

    public EventBasicDto() {}

    public EventBasicDto(String title, String location,
                         LocalDateTime startDate, LocalDateTime endDate, String city) {

        this.title = title;
        this.location = location;
        this.eventDate = DateUtils.formatEventDate(startDate, endDate);
        this.city = city;
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

    public void setEventDate(LocalDateTime startDate, LocalDateTime endDate) {
        this.eventDate = DateUtils.formatEventDate(startDate, endDate);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
