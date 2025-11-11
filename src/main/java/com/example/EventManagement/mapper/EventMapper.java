package com.example.EventManagement.mapper;

import com.example.EventManagement.dto.*;
import com.example.EventManagement.entity.City;
import com.example.EventManagement.entity.Event;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {

    // Mapper to BasicDto
    public EventBasicDto toBasicDto(Event event) {
        EventBasicDto dto = new EventBasicDto();
        mapCommonFields(event, dto);  // Map common fields
        return dto;
    }

    public List<EventBasicDto> toBasicDtoList(List<Event> events) {
        if (events == null) return Collections.emptyList();
        return events.stream()
                .map(this::toBasicDto)
                .collect(Collectors.toList());
    }

    // Mapper to DetailedDto
    public EventDetailedDto toDetailedDto(Event event) {
        EventDetailedDto dto = new EventDetailedDto();
        mapCommonFields(event, dto);
        dto.setDescription(event.getDescription());
        dto.setAddress(event.getAddress() != null ? event.getAddress() : "Unknown");
        dto.setEventStatusId(event.getEventStatus() != null ? event.getEventStatus().getEventStatusId() : null);
        dto.setEventStatus(event.getEventStatus() != null ? event.getEventStatus().getStatusName() : "Unknown");
        return dto;
    }

    public List<EventDetailedDto> toDetailedDtoList(List<Event> events) {
        if (events == null) return Collections.emptyList();
        return events.stream()
                .map(this::toDetailedDto)
                .collect(Collectors.toList());
    }

    // Mapper to CityDto
    private CityDto mapCity(City city) {
        CityDto cityDto = new CityDto();
        if (city != null) {
            cityDto.setCityId(city.getCityId());
            cityDto.setCityName(city.getCityName() != null ? city.getCityName() : "Unknown");
            cityDto.setState(city.getState() != null ? city.getState() : "Unknown");
            cityDto.setCountry(city.getCountry() != null ? city.getCountry() : "Unknown");
        } else {
            cityDto.setCityId(null);
            cityDto.setCityName("Unknown");
            cityDto.setState("Unknown");
            cityDto.setCountry("Unknown");
        }
        return cityDto;
    }


    private void mapCommonFields(Event event, EventBasicDto dto) {
        dto.setEventId(event.getEventId());
        dto.setTitle(event.getTitle());
        dto.setLocation(event.getLocation() != null ? event.getLocation() : "Unknown");
        dto.setStartDate(event.getStartDate());
        dto.setEndDate(event.getEndDate());
        dto.setCity(mapCity(event.getCity()));
        dto.setCategoryId(event.getCategory() != null ? event.getCategory().getCategoryId() : null);
        dto.setCategoryName(event.getCategory() != null ? event.getCategory().getCategoryName() : "Unknown");
    }

}
