package com.example.EventManagement.security;

import com.example.EventManagement.entity.Role;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.repository.RoleRepository;
import com.example.EventManagement.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class Auth0OAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Auth0OAuth2UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");
        String firstName = oAuth2User.getAttribute("given_name");
        String lastName = oAuth2User.getAttribute("family_name");

        // 👇 Använd den befintliga metoden du redan har
        User user = findOrCreateUser(email, firstName, lastName);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName())),
                oAuth2User.getAttributes(),
                "sub"
        );
    }



    private User findOrCreateUser(String email, String firstName, String lastName) {
        Optional<User> existingUser = userRepository.findByEmail(email.toLowerCase());

        if (existingUser.isPresent()) {
            System.out.println("✅ Existing user found: " + email);
            return existingUser.get();
        }

        // Create new user with Participant role
        Role participantRole = roleRepository.findByRoleName("Participant")
                .orElseThrow(() -> new RuntimeException("Default role 'Participant' not found in database"));

        User newUser = new User();
        newUser.setEmail(email.toLowerCase());
        newUser.setFirstName(firstName != null ? firstName : "User");
        newUser.setLastName(lastName != null ? lastName : "");
        newUser.setPassword("OAUTH_USER"); // No password for OAuth users
        newUser.setRegistrationDate(LocalDateTime.now());
        newUser.setRole(participantRole);
        newUser.setEnabled(true);

        User savedUser = userRepository.save(newUser);
        System.out.println("✅ New user created: " + email + " (ID: " + savedUser.getUserId() + ")");

        return savedUser;
    }
}