package com.example.EventManagement.service;

import com.example.EventManagement.dto.UserUpcomingEventDto;
import com.example.EventManagement.entity.EventParticipant;
import com.example.EventManagement.entity.ParticipantStatus;
import com.example.EventManagement.repository.ParticipantStatusRepository;

import com.example.EventManagement.entity.Role;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.mapper.EventMapper;
import com.example.EventManagement.payload.request.UserRegistrationDto;
import com.example.EventManagement.payload.response.ApiResponseWrapper;
import com.example.EventManagement.payload.response.ApiResponseWrapperEvent;
import com.example.EventManagement.repository.EventParticipantRepository;
import com.example.EventManagement.repository.RoleRepository;
import com.example.EventManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private ParticipantStatusRepository participantStatusRepository;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final EventParticipantRepository eventParticipantRepository;
    private final EventMapper eventMapper;


    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,EventParticipantRepository eventParticipantRepository,EventMapper eventMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.eventParticipantRepository= eventParticipantRepository;
        this.eventMapper = eventMapper;

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
    public List<UserUpcomingEventDto> getUpcomingEventsForUser(Long userId) {
        List<EventParticipant> participants =
                eventParticipantRepository.findUpcomingEventParticipants(userId);

        return participants.stream()
                .map(p -> eventMapper.toUserUpcomingEventDto(p.getEvent()))
                .toList();
    }

    // Before updating checks if the user is actually registered:
    public ApiResponseWrapperEvent<String> unregisterUserFromEvent(Long userId, Long eventId) {
        EventParticipant eventParticipant = eventParticipantRepository
                .findByUserUserIdAndEventEventId(userId, eventId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "The participant is not registered for this event"
                ));
        // checks that event has passed
        if (eventParticipant.getEvent().getStartDate().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "You cannot unregister from an event that has already passed"
            );
        }
        // Retrieves the "Cancelled" status from the ParticipantStatus table to make en  update.
        ParticipantStatus cancelledStatus = participantStatusRepository
                .findByStatusName("Cancelled")
                .orElseThrow(() -> new ResponseStatusException(
                        // Throws a ResponseStatusException(400) if  status is not found.
                        HttpStatus.BAD_REQUEST, "Cancelled status not found"
                ));
        eventParticipant.setParticipantStatus(cancelledStatus);
        // Save the updated EventParticipant entity to persist the change in database
        eventParticipantRepository.save(eventParticipant);
//   Then Return a success message wrapped in ApiResponseWrapper
        return new ApiResponseWrapperEvent<>("SUCCESS", "User successfully unregistered from event", null);
    }


}
