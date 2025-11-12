package com.example.EventManagement.security;

import com.example.EventManagement.entity.User;
import com.example.EventManagement.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Auth0LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserRepository userRepository;

    public Auth0LoginSuccessHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        // Get OAuth2User (works for both OAuth2User and OidcUser)
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();

        // Extract email from Auth0
        String email = oauth2User.getAttribute("email");

        if (email == null) {
            System.err.println("❌ No email found in OAuth2User attributes");
            getRedirectStrategy().sendRedirect(request, response, "http://localhost:3000/login?error=true");
            return;
        }

        // Find user in database
        User user = userRepository.findByEmail(email.toLowerCase())
                .orElse(null);

        if (user == null) {
            System.err.println("❌ User not found in database: " + email);
            getRedirectStrategy().sendRedirect(request, response, "http://localhost:3000/login?error=true");
            return;
        }

        // Store user info in session
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getUserId());
        session.setAttribute("userEmail", user.getEmail());
        session.setAttribute("userName", user.getFirstName() + " " + user.getLastName());
        session.setAttribute("userRole", user.getRole().getRoleName());

        // Log successful login
        System.out.println("✅ User logged in: " + user.getEmail() + " (ID: " + user.getUserId() + ")");

        // Redirect to frontend
        getRedirectStrategy().sendRedirect(request, response, "http://localhost:3000");
    }
}