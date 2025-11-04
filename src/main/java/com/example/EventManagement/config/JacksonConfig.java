package com.example.EventManagement.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        Hibernate6Module module = new Hibernate6Module();

        // Configure the module as needed; e.g., avoid forcing lazy loading
        module.disable(Hibernate6Module.Feature.FORCE_LAZY_LOADING);

        mapper.registerModule(module);

        // Register Java Time module to handle java.time.* types like LocalDateTime
        mapper.registerModule(new JavaTimeModule());

        // Configure serialization to write dates as ISO strings instead of timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper;
    }
}
