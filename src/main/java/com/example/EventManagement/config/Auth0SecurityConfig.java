package com.example.EventManagement.config;

import com.example.EventManagement.security.Auth0OAuth2UserService;
import com.example.EventManagement.security.Auth0OidcUserService;
import com.example.EventManagement.security.Auth0LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Auth0SecurityConfig {

    private final Auth0OAuth2UserService auth0OAuth2UserService;
    private final Auth0OidcUserService auth0OidcUserService;
    private final Auth0LoginSuccessHandler auth0LoginSuccessHandler;

    public Auth0SecurityConfig(Auth0OAuth2UserService auth0OAuth2UserService,
                               Auth0OidcUserService auth0OidcUserService,
                               Auth0LoginSuccessHandler auth0LoginSuccessHandler) {
        this.auth0OAuth2UserService = auth0OAuth2UserService;
        this.auth0OidcUserService = auth0OidcUserService;
        this.auth0LoginSuccessHandler = auth0LoginSuccessHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        // Public endpoints
                        .requestMatchers("/", "/api/events/**", "/api/auth/check", "/error").permitAll()

                        // Protected endpoints
                        .requestMatchers("/api/participants/**").authenticated()
                        .requestMatchers("/api/reviews/**").authenticated()
                        .requestMatchers("/api/my-events/**").authenticated()

                        // Admin only
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/roles/**").hasRole("ADMIN")
                        .requestMatchers("/api/categories/**").hasRole("ADMIN")
                        .requestMatchers("/api/event_statuses/**").hasRole("ADMIN")
                        .requestMatchers("/api/participant_statuses/**").hasRole("ADMIN")
                        .requestMatchers("/api/cities/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(auth0OAuth2UserService)
                                .oidcUserService(auth0OidcUserService)  // VIKTIGT! OIDC user service
                        )
                        .successHandler(auth0LoginSuccessHandler)
                        .failureUrl("http://localhost:3000/login?error=true")
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("http://localhost:3000")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }
}