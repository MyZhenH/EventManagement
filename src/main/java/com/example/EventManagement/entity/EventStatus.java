package com.example.EventManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event_statuses")
public class EventStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_status_id")
    private Long eventStatusId;

    @Column(name = "status_name")
    private String statusName;

    public EventStatus() {
    }

    public EventStatus(Long eventStatusId, String statusName) {
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
