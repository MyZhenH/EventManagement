package com.example.EventManagement.controller;

import com.example.EventManagement.dto.UserDto;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/check")
    public ResponseEntity<Map<String, Object>> checkAuth(
            @AuthenticationPrincipal OAuth2User oauth2User) {

        Map<String, Object> response = new HashMap<>();

        if (oauth2User != null) {
            // Get email from OAuth2User
            String email = oauth2User.getAttribute("email");

            if (email != null) {
                // Find user in database
                User user = userRepository.findByEmail(email.toLowerCase()).orElse(null);

                if (user != null) {
                    UserDto userDto = new UserDto(
                            user.getUserId(),
                            user.getFirstName(),
                            user.getLastName(),
                            user.getEmail(),
                            user.getRole().getRoleName()
                    );

                    response.put("authenticated", true);
                    response.put("user", userDto);

                    System.out.println("✅ Auth check: User " + user.getEmail() + " is authenticated");
                    return ResponseEntity.ok(response);
                }
            }
        }

        response.put("authenticated", false);
        System.out.println("❌ Auth check: No user authenticated");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        String userEmail = (String) session.getAttribute("userEmail");
        session.invalidate();

        response.put("success", true);
        response.put("message", "Logout complete");

        System.out.println("👋 User logged out: " + userEmail);

        return ResponseEntity.ok(response);
    }
}