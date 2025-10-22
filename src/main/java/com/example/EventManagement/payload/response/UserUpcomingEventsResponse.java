package com.example.EventManagement.payload.response;

import com.example.EventManagement.dto.UserUpcomingEventDto;

import java.util.List;
// a wrapper class used to return a messege in  output not only data
public class UserUpcomingEventsResponse {
    private String message;
    private List<UserUpcomingEventDto> events;

    public UserUpcomingEventsResponse(String message, List<UserUpcomingEventDto> events) {
        this.message = message;
        this.events = events;
    }

    public String getMessage() {
        return message;
    }

    public List<UserUpcomingEventDto> getEvents() {
        return events;
    }
}
