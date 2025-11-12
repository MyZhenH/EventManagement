package com.example.EventManagement.security;

import com.example.EventManagement.entity.Role;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.repository.RoleRepository;
import com.example.EventManagement.repository.UserRepository;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Auth0OidcUserService extends OidcUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Auth0OidcUserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("🔵 Auth0OidcUserService.loadUser() called");

        try {
            // Let Spring handle the OIDC user loading
            OidcUser oidcUser = super.loadUser(userRequest);
            System.out.println("🔵 OidcUser loaded successfully");

            // Debug: Print all attributes
            System.out.println("🔍 OidcUser attributes: " + oidcUser.getAttributes());

            // Extract user info from Auth0
            String email = oidcUser.getAttribute("email");
            System.out.println("🔍 Email extracted: " + email);

            if (email == null) {
                System.err.println("❌ Email is null!");
                throw new OAuth2AuthenticationException("Email not found from Auth0");
            }

            // Find or create user in our database
            findOrCreateUser(email, oidcUser);
            System.out.println("✅ User processed successfully");

            // Return the OidcUser as-is
            return oidcUser;

        } catch (Exception e) {
            System.err.println("❌ ERROR in loadUser: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    private void findOrCreateUser(String email, OidcUser oidcUser) {
        System.out.println("🔵 findOrCreateUser() called for: " + email);

        Optional<User> existingUser = userRepository.findByEmail(email.toLowerCase());

        if (existingUser.isPresent()) {
            System.out.println("✅ Existing user found: " + email);
            return;
        }

        System.out.println("🔵 Creating new user...");

        // Extract name information
        String givenName = oidcUser.getGivenName();
        String familyName = oidcUser.getFamilyName();
        String fullName = oidcUser.getFullName();
        String nickname = oidcUser.getNickName();

        System.out.println("🔍 Name info - givenName: " + givenName + ", familyName: " + familyName + ", fullName: " + fullName);

        // Parse first and last name
        String firstName = givenName;
        String lastName = familyName;

        if (firstName == null && fullName != null) {
            String[] nameParts = fullName.split(" ", 2);
            firstName = nameParts[0];
            lastName = nameParts.length > 1 ? nameParts[1] : "";
        }

        if (firstName == null && nickname != null) {
            firstName = nickname;
        }

        if (firstName == null) {
            firstName = "User";
        }

        if (lastName == null) {
            lastName = "";
        }

        System.out.println("🔍 Parsed name - firstName: " + firstName + ", lastName: " + lastName);

        // Find Participant role
        System.out.println("🔵 Looking for Participant role...");
        Role participantRole = roleRepository.findByRoleName("Participant")
                .orElseThrow(() -> {
                    System.err.println("❌ Role 'Participant' not found in database!");
                    return new RuntimeException("Role 'Participant' not found");
                });
        System.out.println("✅ Participant role found: " + participantRole.getRoleId());

        // Create new user
        User newUser = new User();
        newUser.setEmail(email.toLowerCase());
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPassword("OAUTH_USER");
        newUser.setRegistrationDate(LocalDateTime.now());
        newUser.setRole(participantRole);
        newUser.setEnabled(true);

        System.out.println("🔵 Saving new user to database...");
        try {
            User savedUser = userRepository.save(newUser);
            System.out.println("✅ New user created: " + email + " (ID: " + savedUser.getUserId() + ")");
        } catch (Exception e) {
            System.err.println("❌ Error saving user: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}