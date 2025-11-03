package com.example.EventManagement.startup;

import com.example.EventManagement.entity.Role;
import com.example.EventManagement.entity.User;
import com.example.EventManagement.repository.RoleRepository;
import com.example.EventManagement.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AdminUserInitializer implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminUserInitializer.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminUserInitializer(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (userRepository.existsByEmail("admin@example.com")) {
            // Admin user already exists, no action needed
            return;
        }

        Role adminRole = roleRepository.findByRoleName("Admin")
                .orElseThrow(() -> new IllegalStateException("Role 'Admin' not found"));

        User admin = new User();

        admin.setFirstName("Admin");
        admin.setLastName("User");
        admin.setEmail("admin@example.com");
        admin.setPassword(passwordEncoder.encode("secureAdminPassword"));
        admin.setRegistrationDate(LocalDateTime.now().withNano(0));
        admin.setRole(adminRole);

        userRepository.save(admin);

        LOGGER.info("Admin user created with email: {} and password: {}",
                admin.getEmail(), "secureAdminPassword");
    }
}
