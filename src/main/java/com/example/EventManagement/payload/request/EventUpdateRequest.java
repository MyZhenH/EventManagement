package com.example.EventManagement.payload.request;

import java.time.LocalDateTime;

public record EventUpdateRequest(
    String title,
    String description,
    LocalDateTime startDate,
    LocalDateTime endDate,
    String location,
    Long categoryId,
    Long eventStatusId
) {}
