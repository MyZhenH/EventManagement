package com.example.EventManagement.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventRequestDto(
        @NotBlank String title,
        @NotBlank String description,
        @NotNull LocalDateTime eventDate,
        @NotBlank String location,
        @NotNull Long categoryId,
        @NotNull Long eventStatusId
) {}
