package com.example.EventManagement.service;

import com.example.EventManagement.entity.Role;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.payload.request.RegisterRequest;
import com.example.EventManagement.repository.RoleRepository;
import com.example.EventManagement.repository.UserRepository;
import com.example.EventManagement.utils.PasswordUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * Authenticating a user with email and password
     */
    public User authenticate(String email, String password) {
        if (email == null || email.trim().isEmpty()) {
            throw new RuntimeException("Email is mandatory");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new RuntimeException("Password is mandatory");
        }

        // Find user via email
        User user = userRepository.findByEmail(email.trim().toLowerCase())
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Wrong email or password"));

        // Check if account is active
        if (!user.isEnabled()) {
            throw new RuntimeException("Account is inactive");
        }

        // Validate password
        if (!PasswordUtil.verifyPassword(password, user.getPassword())) {
            throw new RuntimeException("Wrong email or password");
        }

        return user;
    }

    /**
     * Register new user
     */
    public User registerUser(RegisterRequest request) {
        // Validate input
        validateRegistrationInput(request);

        String email = request.getEmail().trim().toLowerCase();

        // Control if user already exists
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Account with the same email is already registered");
        }

        // Find Participant-role
        Role participantRole = roleRepository.findByRoleName("Participant")
                .orElseThrow(() -> new RuntimeException("Standardroll 'Participant' not found"));

        // Creates new users
        User user = new User();
        user.setFirstName(request.getFirstName().trim());
        user.setLastName(request.getLastName().trim());
        user.setEmail(email);
        user.setPassword(PasswordUtil.hashPassword(request.getPassword()));
        user.setRegistrationDate(LocalDateTime.now());
        user.setRole(participantRole);
        user.setEnabled(true);

        return userRepository.save(user);
    }

    /**
     * Gets users with ID
     */
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Validates registration input
     */
    private void validateRegistrationInput(RegisterRequest request) {
        if (request.getFirstName() == null || request.getFirstName().trim().isEmpty()) {
            throw new RuntimeException("First name is mandatory");
        }

        if (request.getLastName() == null || request.getLastName().trim().isEmpty()) {
            throw new RuntimeException("Last name is mandatory");
        }

        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new RuntimeException("Email is mandatory");
        }

        if (!isValidEmail(request.getEmail())) {
            throw new RuntimeException("Invalid email-format");
        }

        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password is mandatory");
        }

        validatePassword(request.getPassword());
    }

    /**
     * Validate password according to security standards
     */
    private void validatePassword(String password) {
        if (password.length() < 8) {
            throw new RuntimeException("Password needs to be atleast 8 characters long");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new RuntimeException("Password needs to contain atleast one big letter");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new RuntimeException("Password needs to contain atleast one small letter");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new RuntimeException("Password needs to contain atleast one number");
        }
    }

    /**
     * Validate email
     */
    private boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }
}