package com.example.EventManagement.mapper;

import com.example.EventManagement.dto.UserUpcomingEventDto;
import com.example.EventManagement.entity.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public UserUpcomingEventDto toUserUpcomingEventDto(Event event) {
        if (event == null) return null;

        return new UserUpcomingEventDto(
                event.getEventId(),
                event.getTitle(),
                event.getLocation(),
                event.getDescription(),
                event.getStartDate(),
                event.getEndDate(),
                event.getEventStatus() != null ? event.getEventStatus().getStatusName() : null
        );
    }

}
