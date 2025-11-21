package com.example.EventManagement.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTime converter to SQLite DateTime
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, String> {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String convertToDatabaseColumn(LocalDateTime attribute) {
        return attribute != null ? attribute.format(FORMATTER) : null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }

        // Handle both formats that might be in your DB
        try {
            // Try ISO format first (2025-09-01T08:00:00)
            return LocalDateTime.parse(dbData);
        } catch (Exception e) {
            // Fall back to SQLite format (2025-09-01 08:00:00)
            return LocalDateTime.parse(dbData, FORMATTER);
        }
    }
}

