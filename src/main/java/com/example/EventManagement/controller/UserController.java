package com.example.EventManagement.controller;

import com.example.EventManagement.entity.User;
import com.example.EventManagement.payload.request.UserRegistrationDto;
import com.example.EventManagement.payload.response.ApiResponseWrapper;
import com.example.EventManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponseWrapper<User>> registerNewUser(
            @Valid @RequestBody UserRegistrationDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            // Collect validation errors into a message string or list
            String errorMessage = result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));

            ApiResponseWrapper<User> errorResponse = ApiResponseWrapper.error(errorMessage);

            return ResponseEntity.badRequest().body(errorResponse);
        }

        ApiResponseWrapper<User> response = userService.registerNewUser(userDto);

        if ("success".equalsIgnoreCase(response.getStatus())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
