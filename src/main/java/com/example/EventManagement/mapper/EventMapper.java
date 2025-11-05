package com.example.EventManagement.mapper;

import com.example.EventManagement.dto.CityDto;
import com.example.EventManagement.dto.EventBasicDto;
import com.example.EventManagement.dto.EventDetailedDto;
import com.example.EventManagement.dto.EventStatusInfoDto;
import com.example.EventManagement.entity.Event;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {

    // Mapper to Basic DTO
    public EventBasicDto toBasicDto(Event event) {

        EventBasicDto dto = new EventBasicDto();
        dto.setEventId(event.getEventId());
        dto.setTitle(event.getTitle());
        dto.setLocation(event.getLocation());
        dto.setStartDate(event.getStartDate());
        dto.setEndDate(event.getEndDate());

        // Mapper to City DTO
        CityDto cityDto = new CityDto();

        if (event.getCity() != null) {
            cityDto.setCityId(event.getCity().getCityId());
            cityDto.setCityName(event.getCity().getCityName() != null ? event.getCity().getCityName() : "Unknown");
            cityDto.setState(event.getCity().getState() != null ? event.getCity().getState() : "Unknown");
            cityDto.setCountry(event.getCity().getCountry() != null ? event.getCity().getCountry() : "Unknown");
        } else {
            cityDto.setCityId(null);
            cityDto.setCityName("Unknown");
            cityDto.setState("Unknown");
            cityDto.setCountry("Unknown");
        }
        dto.setCity(cityDto);

        return dto;
    }

    public List<EventBasicDto> toBasicDtoList(List<Event> events) {
        if (events == null) return Collections.emptyList();
        return events.stream()
                .map(this::toBasicDto)
                .collect(Collectors.toList());
    }


    // Mapper to Detailed DTO
    public EventDetailedDto toDetailedDto(Event event) {

        EventDetailedDto dto = new EventDetailedDto();
        dto.setEventId(event.getEventId());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setStartDate(event.getStartDate());
        dto.setEndDate(event.getEndDate());
        dto.setLocation(event.getLocation() != null ? event.getLocation() : "Not Determined");
        dto.setAddress(event.getAddress() != null ? event.getAddress() : "Unknown");

        // Mapper to City DTO
        CityDto cityDto = new CityDto();

        if (event.getCity() != null) {
            cityDto.setCityId(event.getCity().getCityId());
            cityDto.setCityName(event.getCity().getCityName() != null ? event.getCity().getCityName() : "Unknown");
            cityDto.setState(event.getCity().getState() != null ? event.getCity().getState() : "Unknown");
            cityDto.setCountry(event.getCity().getCountry() != null ? event.getCity().getCountry() : "Unknown");
        } else {
            cityDto.setCityId(null);
            cityDto.setCityName("Unknown");
            cityDto.setState("Unknown");
            cityDto.setCountry("Unknown");
        }
        dto.setCity(cityDto);


        // Mapper to EventStatusInfo DTO
        EventStatusInfoDto statusDto = new EventStatusInfoDto();

        if (event.getEventStatus() != null) {
            statusDto.setEventStatusId(event.getEventStatus().getEventStatusId());
            statusDto.setStatusName(event.getEventStatus().getStatusName() != null ? event.getEventStatus().getStatusName() : "Unknown");
        } else {
            statusDto.setEventStatusId(null);
            statusDto.setStatusName("Unknown");
        }
        dto.setEventStatus(statusDto);

        return dto;

    }

    public List<EventDetailedDto> toDetailedDtoList(List<Event> event) {
        if (event == null) return Collections.emptyList();
        return event.stream()
                .map(this::toDetailedDto)
                .collect(Collectors.toList());
    }


}
