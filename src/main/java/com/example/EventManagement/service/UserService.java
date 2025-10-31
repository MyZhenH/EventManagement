package com.example.EventManagement.service;

import com.example.EventManagement.entity.Role;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.payload.request.UserRegistrationDto;
import com.example.EventManagement.payload.response.ApiResponseWrapper;
import com.example.EventManagement.repository.RoleRepository;
import com.example.EventManagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ApiResponseWrapper<User> registerNewUser(UserRegistrationDto dto) {
        try {
            if (userRepository.existsByEmail(dto.email().toLowerCase())) {
                return new ApiResponseWrapper<>("error", "User with email already exists", null);
            }

            // Assigns the default "Participant" role to user
            Role participantRole = roleRepository.findByRoleName("Participant")
                    .orElseThrow(() -> new RuntimeException("Default role 'Participant' not found"));

            User user = new User();

            user.setFirstName(dto.firstName().trim());
            user.setLastName(dto.lastName().trim());
            user.setEmail(dto.email().toLowerCase());
            user.setPhone(dto.phone());
            user.setPassword(passwordEncoder.encode(dto.password()));

            // Output will be "YYYY-MM-DDTHH:MM:SS" instead of "YYYY-MM-DDTHH:MM:SS.sss"
            user.setRegistrationDate(LocalDateTime.now().withNano(0));

            user.setRole(participantRole);

            User savedUser = userRepository.save(user);

            return new ApiResponseWrapper<>("success", "User registered successfully", savedUser);
        } catch (RuntimeException e) {
            return new ApiResponseWrapper<>(
                    "error",
                    "Registration failed: " + e.getMessage(),
                    null);
        }
    }
}
