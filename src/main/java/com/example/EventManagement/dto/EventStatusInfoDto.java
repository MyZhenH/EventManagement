package com.example.EventManagement.dto;


public class EventStatusInfoDto {

    private Long eventStatusId;
    private String statusName;

    public EventStatusInfoDto() {
    }

    public EventStatusInfoDto(Long eventStatusId, String statusName) {
        this.eventStatusId = eventStatusId;
        this.statusName = statusName;
    }

    public Long getEventStatusId() {
        return eventStatusId;
    }

    public void setEventStatusId(Long eventStatusId) {
        this.eventStatusId = eventStatusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
