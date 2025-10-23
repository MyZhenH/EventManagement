package com.example.EventManagement.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Utility class for password hashing and verification using BCrypt.
 * This class provides methods to securely hash passwords and verify them
 * without requiring Spring Security dependency.
 */
public class PasswordUtil {

    // BCrypt work factor (default 10, higher = more secure but slower)
    private static final int WORK_FACTOR = 10;

    /**
     * Hashes a plain text password using BCrypt.
     *
     * @param plainPassword the password to hash
     * @return the hashed password
     */
    public static String hashPassword(String plainPassword) {
        if (plainPassword == null || plainPassword.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(WORK_FACTOR));
    }

    /**
     * Verifies if a plain text password matches a hashed password.
     *
     * @param plainPassword  the plain text password to verify
     * @param hashedPassword the hashed password to compare against
     * @return true if the passwords match, false otherwise
     */
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        if (plainPassword == null || hashedPassword == null) {
            return false;
        }

        try {
            return BCrypt.checkpw(plainPassword, hashedPassword);
        } catch (IllegalArgumentException e) {
            // Invalid hash format
            return false;
        }
    }
}