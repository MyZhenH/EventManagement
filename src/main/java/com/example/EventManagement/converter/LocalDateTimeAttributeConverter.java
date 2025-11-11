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

        private static final DateTimeFormatter DB_FORMATTER =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public String convertToDatabaseColumn(LocalDateTime attribute) {
            return attribute != null ? attribute.format(DB_FORMATTER) : null;
        }

        @Override
        public LocalDateTime convertToEntityAttribute(String dbData) {
            return dbData != null ? LocalDateTime.parse(dbData, DB_FORMATTER) : null;
        }



}



