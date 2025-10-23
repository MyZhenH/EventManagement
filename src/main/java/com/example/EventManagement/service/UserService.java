package com.example.EventManagement.service;

import com.example.EventManagement.dto.UserUpcomingEventDto;
import com.example.EventManagement.entity.Event;
import com.example.EventManagement.entity.EventParticipant;
import com.example.EventManagement.entity.Role;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.exception.PasswordException;
import com.example.EventManagement.repository.EventParticipantRepository;
import com.example.EventManagement.repository.RoleRepository;
import com.example.EventManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final EventParticipantRepository eventParticipantRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,EventParticipantRepository eventParticipantRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.eventParticipantRepository= eventParticipantRepository;
    }

    public Map<String, String> registerUser(User user) {
        Map<String, String> response = new HashMap<>();

        String firstName = user.getFirstName() != null ? user.getFirstName().trim() : null;
        String lastName = user.getLastName() != null ? user.getLastName().trim() : null;
        String email = user.getEmail() != null ? user.getEmail().trim().toLowerCase() : null;
        String phone = user.getPhone() != null ? user.getPhone().trim() : null;
        String password = user.getPassword() != null ? user.getPassword().trim() : null;

        // Check if first name is filled in
        if (firstName == null || firstName.isEmpty()) {
            response.put("status", "error");
            response.put("message", "First name is required");
            return response;
        }

        // Check if last name is filled in
        if (lastName == null || lastName.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Last name is required");
            return response;
        }

        // Check if phone number contains digits
        if (phone != null && !phone.isEmpty() && !phone.matches("\\d+")) {
            response.put("status", "error");
            response.put("message", "Phone number can only contain digits");
            return response;
        }

        // Check if email is filled in
        if (email == null || email.isEmpty()){
                response.put("status", "error");
                response.put("message", "Email is required");
                return response;
        }

        // Validate Email format
        if (!isValidEmail(email)) {
            response.put("status", "error");
            response.put("message", "Invalid email format");
            return response;
        }

        // Check if password is filled in
        if (password == null || password.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Password is required");
            return response;
        }

        // Validation - Check if the password meet the requirements
        passwordValidation(password);

        // Validation - Check if the user already exists
        if (userRepository.existsByEmail(email)) {
            response.put("status", "error");
            response.put("message", "User already exists");
            return response;
        }

        // Assigns the default "Participant" role to user
        Role participantRole = roleRepository.findByRoleName("Participant")
                .orElseThrow(() -> new RuntimeException("Default role 'Participant' not found"));

        user.setRole(participantRole);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email.toLowerCase());
        user.setPhone(phone);
        user.setRegistrationDate(LocalDateTime.now().withNano(0));
        user.setPassword(password);

        userRepository.save(user);
        response.put("status", "success");
        response.put("message", "Registration successful");
        return response;
    }

    /**
     * Validates a password according to certain security rules.
     *  The password must:
     *  <ul>
     *      <li> Be non-null and non-empty
     *      <li> Contain at least 8 characters
     *      <li> Contain at least one uppercase letter
     *      <li> Contain at least one lowercase letter
     *      <li> Contain at least one digit
     *  </ul>
     *
     * @param password the password to be validated
     * @throws PasswordException if the password is invalid based on the above rules
     */
    public void passwordValidation(String password) {
        if (password == null || password.isEmpty()) {
            throw new PasswordException("Password cannot be empty");
        }
        if (password.length() < 8) {
            throw new PasswordException("Password must be at least 8 characters long");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new PasswordException("Password must contain at least one uppercase letter");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new PasswordException("Password must contain at least one lowercase letter");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new PasswordException("Password must contain at least one number");
        }
    }

    /**
     * Validates whether the given email address has a valid format.
     * <p>
     * This method checks if the email is not {@code null} and matches a regular expression
     * pattern that represents a standard email format (e.g., user@example.com).
     * </p>
     *
     * @param email the email address to validate
     * @return {@code true} if the email is not null and matches the expected format,
     *         otherwise {@code false}
     */
    public boolean isValidEmail(String email) {
        if (email == null){
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
    public List<UserUpcomingEventDto> getUpcomingEventsForUser(long userId) {
        // Gets all upcoming events for the user
        List<EventParticipant> eventParticipants =
                eventParticipantRepository.findUpcomingEventParticipantsByUserAndStatus(userId, 2L); // registeredStatusId if needed

        List<UserUpcomingEventDto> upcomingEvents = new ArrayList<>();

        for (EventParticipant p : eventParticipants) {
            Event event = p.getEvent();
            UserUpcomingEventDto dto = new UserUpcomingEventDto(event);
            upcomingEvents.add(dto);
        }

        return upcomingEvents;
    }


}