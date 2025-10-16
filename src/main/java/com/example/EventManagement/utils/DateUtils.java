package com.example.EventManagement.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Utility class for working with date and time formats.
 * This class provides utility methods for formatting date and time in a user-friendly way.
 */
public class DateUtils {

    /**
     * Formats into a human-readable string with the format "dd MMMM, yyyy, HH:mm".
     * If the {@link LocalDateTime} is {@code null}, it returns the string "Not Determined" as a placeholder.
     *
     * @param eventDate The {@link LocalDateTime} representing the event's date and time.
     * @return A formatted string representing the event date, or "Not Determined" if the date is {@code null}.
     */
    public static String formatEventDate(LocalDateTime eventDate) {
        if (eventDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy, HH:mm");
            return eventDate.format(formatter);
        }

        return "Not Determined";
    }
}
