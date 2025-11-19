package com.example.EventManagement.payload.request;

import java.time.LocalDateTime;

public record EventUpdateRequest(
    String title,
    String description,
    LocalDateTime startDate,
    LocalDateTime endDate,
    String location,
    // new field added
    String address,
    // new field added
    Long cityId,
    Long categoryId,
    Long eventStatusId
) {}
