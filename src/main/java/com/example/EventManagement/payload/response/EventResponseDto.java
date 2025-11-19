package com.example.EventManagement.payload.response;

import java.time.LocalDateTime;

public record EventResponseDto(
        Long eventId,
        String title,
        String description,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String location,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long createdByUserId,
        Long updatedByUserId,
        // new field address
        String address,
        // new field city
        Long cityId,
        Long categoryId,
        Long eventStatusId
) {}
