package com.example.EventManagement.mapper;

import com.example.EventManagement.dto.*;
import com.example.EventManagement.entity.Category;
import com.example.EventManagement.entity.City;
import com.example.EventManagement.entity.Event;
import com.example.EventManagement.entity.EventStatus;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

        EventStatus status = event.getEventStatus();
        if (status != null) {
            dto.setEventStatusId(status.getEventStatusId());
            dto.setEventStatus(Optional.ofNullable(status.getStatusName()).orElse("Unknown"));
        } else {
            dto.setEventStatusId(null);
            dto.setEventStatus("Unknown");
        }

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

        Long cityId = city.getCityId();
        String cityName = city.getCityName();
        String state = city.getState();
        String country = city.getCountry();

        cityDto.setCityId(cityId);
        cityDto.setCityName(cityName != null ? cityName : "Unknown");
        cityDto.setState(state != null ? state : "Unknown");
        cityDto.setCountry(country != null ? country : "Unknown");

        return cityDto;

    }


    private void mapCommonFields(Event event, EventBasicDto dto) {
        dto.setEventId(event.getEventId());
        dto.setTitle(event.getTitle());
        dto.setLocation(event.getLocation() != null ? event.getLocation() : "Unknown");
        dto.setStartDate(event.getStartDate());
        dto.setEndDate(event.getEndDate());
        dto.setCity(mapCity(event.getCity()));

        Category category = event.getCategory();
        if (category != null) {
            dto.setCategoryId(category.getCategoryId());
            dto.setCategoryName(category.getCategoryName());
        } else {
            dto.setCategoryId(null);
            dto.setCategoryName("Unknown");
        }
    }

}
