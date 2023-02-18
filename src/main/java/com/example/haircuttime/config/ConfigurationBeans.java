package com.example.haircuttime.config;

import com.example.haircuttime.EventHandler.AbsenceRepositoryEventHandler;
import com.example.haircuttime.repository.RoleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ConfigurationBeans {

    private final RoleEntityRepository roleRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AbsenceRepositoryEventHandler absenceRepositoryEventHandler() {
        return new AbsenceRepositoryEventHandler(roleRepository);
    }
}
