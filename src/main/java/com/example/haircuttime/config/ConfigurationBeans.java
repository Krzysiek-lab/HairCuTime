package com.example.haircuttime.config;

import com.example.haircuttime.EventHandler.AbsenceRepositoryEventHandler;
import com.example.haircuttime.repository.AvailabilityRepository;
import com.example.haircuttime.repository.RoleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class ConfigurationBeans {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AbsenceRepositoryEventHandler absenceRepositoryEventHandler(RoleEntityRepository roleRepository, AvailabilityRepository availabilityRepository) {
        return new AbsenceRepositoryEventHandler(roleRepository, availabilityRepository);
    }
}
