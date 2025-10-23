package com.example.EventManagement.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for working with date and time formats.
 * This class provides methods for formatting event start and end dates in a user-friendly way.
 */
public class DateUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd MMMM, yyyy, HH:mm");

    /**
     * Formats event start and end date/time as a human-readable range.
     * If both are null, returns "Not Determined".
     *
     * @param startDate The start date/time of the event.
     * @param endDate The end date/time of the event.
     * @return A formatted string representing the event date range.
     */
    public static String formatEventDate(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            return "Not Determined";
        } else if (startDate != null && endDate == null) {
            return startDate.format(FORMATTER);
        } else if (startDate == null) {
            return endDate.format(FORMATTER);
        } else {
            // Both are not null — format as range
            return startDate.format(FORMATTER) + " - " + endDate.format(FORMATTER);
        }
    }
}
