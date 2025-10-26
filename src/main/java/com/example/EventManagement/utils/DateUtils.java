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

            // If it's the same day: show date once + start and end time
            if (startDate.toLocalDate().equals(endDate.toLocalDate())) {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                return startDate.format(dateFormatter) + " "
                        + startDate.format(timeFormatter) + " - "
                        + endDate.format(timeFormatter);

            } else {
                // If it's different days: show both start and end dates with times
                return startDate.format(FORMATTER) + " - " + endDate.format(FORMATTER);
            }
        }
    }
}
