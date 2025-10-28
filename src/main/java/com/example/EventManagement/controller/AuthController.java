package com.example.EventManagement.controller;

import com.example.EventManagement.dto.UserDto;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.payload.request.LoginRequest;
import com.example.EventManagement.payload.request.RegisterRequest;
import com.example.EventManagement.service.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(
            @Valid @RequestBody LoginRequest loginRequest,
            HttpSession session) {

        Map<String, Object> response = new HashMap<>();

        try {
            User user = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

            // Saves user in session
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userEmail", user.getEmail());
            session.setAttribute("userRole", user.getRole().getRoleName());

            // Creates user DTO for frontend
            UserDto userDto = new UserDto(
                    user.getUserId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getRole().getRoleName()
            );

            response.put("success", true);
            response.put("message", "login successful");
            response.put("user", userDto);

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(
            @Valid @RequestBody RegisterRequest registerRequest) {

        Map<String, Object> response = new HashMap<>();

        try {
            User user = authService.registerUser(registerRequest);

            response.put("success", true);
            response.put("message", "Registration Complete! You can now login.");

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        session.invalidate();

        response.put("success", true);
        response.put("message", "Logout complete");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/check")
    public ResponseEntity<Map<String, Object>> checkAuth(HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        Long userId = (Long) session.getAttribute("userId");

        if (userId != null) {
            User user = authService.getUserById(userId);

            UserDto userDto = new UserDto(
                    user.getUserId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getRole().getRoleName()
            );

            response.put("authenticated", true);
            response.put("user", userDto);
        } else {
            response.put("authenticated", false);
        }

        return ResponseEntity.ok(response);
    }
}