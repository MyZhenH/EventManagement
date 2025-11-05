package com.example.EventManagement.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserRegistrationDto(
    @NotBlank(message = "First name is required")
    String firstName,

    @NotBlank(message = "Last name is required")
    String lastName,

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email,

    @Pattern(regexp = "\\d*", message = "Phone number can only contain digits")
    String phone,

    @NotBlank(message = "Password is required")
    String password
) {}
