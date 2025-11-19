package com.example.EventManagement.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventCreateRequest(
        @NotBlank String title,
        @NotBlank String description,
        @NotNull LocalDateTime startDate,
        @NotNull LocalDateTime endDate,
        @NotBlank String location,
        // added new field address
        String address,
        // added new field city
        @NotNull Long cityId,
        @NotNull Long categoryId,
        @NotNull Long eventStatusId
) {}
