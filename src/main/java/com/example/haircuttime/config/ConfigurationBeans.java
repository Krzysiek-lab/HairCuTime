package com.example.haircuttime.config;

import com.example.haircuttime.EventHandler.AbsenceRepositoryEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ConfigurationBeans {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AbsenceRepositoryEventHandler absenceRepositoryEventHandler() {
        return new AbsenceRepositoryEventHandler();
    }
}
