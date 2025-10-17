package com.example.EventManagement.payload.request;

import java.time.LocalDateTime;

public record EventUpdateRequest(
    String title,
    String description,
    LocalDateTime eventDate,
    String location,
    Long categoryId,
    Long eventStatusId
) {}
