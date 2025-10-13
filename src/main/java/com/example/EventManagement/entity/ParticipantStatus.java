package com.example.EventManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "participant_statuses")
public class ParticipantStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_status_id")
    private Long pStatusId;

    @Column(name = "status_name", unique = true, nullable = false)
    private String statusName;

    public ParticipantStatus() {
    }

    public ParticipantStatus(Long pStatusId, String statusName) {
        this.pStatusId = pStatusId;
        this.statusName = statusName;
    }

    public Long getpStatusId() {
        return pStatusId;
    }

    public void setpStatusId(Long pStatusId) {
        this.pStatusId = pStatusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
