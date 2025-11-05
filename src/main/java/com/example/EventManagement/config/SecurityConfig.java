package com.example.EventManagement.config;

import com.example.EventManagement.security.CustomUserDetailsService;
import com.example.EventManagement.security.JwtAuthenticationFilter;
import com.example.EventManagement.security.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider, CustomUserDetailsService userDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtTokenProvider, userDetailsService);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .exceptionHandling(handler -> handler
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/roles/**").hasRole("ADMIN") // Only admins manage roles
                        .requestMatchers("/api/categories/**").hasRole("ADMIN") // Only admins manage categories
                        .requestMatchers("/api/event_statuses/**").hasRole("ADMIN")
                        .requestMatchers("/api/participant_statuses/**").hasRole("ADMIN")

                        .requestMatchers("/api/users/**").hasAnyRole("ADMIN", "USER") // Users and admins can access users (e.g., for profiles)
                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole("ADMIN", "USER") // Allow read for users
                        .requestMatchers(HttpMethod.POST, "/api/users/").permitAll() // Allow user registration without auth
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN") // Update user details restricted

                        .requestMatchers("/api/cities/**").hasRole("ADMIN") // Manage cities restricted to admins

                        .requestMatchers(HttpMethod.POST, "/api/events/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/events/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/events/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/events/**").permitAll()

                        .requestMatchers("/api/event_participants/**").authenticated() // Participants management allowed for authenticated users

                        .requestMatchers("/api/reviews/**").authenticated() // Authenticated users can manage reviews

                        .anyRequest().denyAll() // Deny anything else by default
                )
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
