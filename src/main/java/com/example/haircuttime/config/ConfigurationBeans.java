package com.example.haircuttime.config;

import com.example.haircuttime.EventHandler.AbsenceRepositoryEventHandler;
import lombok.RequiredArgsConstructor;
import com.example.haircuttime.repository.AvailabilityRepository;
import com.example.haircuttime.repository.RoleEntityRepository;
import com.example.haircuttime.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
@AllArgsConstructor
public class ConfigurationBeans {

    private final RoleEntityRepository roleRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AbsenceRepositoryEventHandler absenceRepositoryEventHandler(RoleEntityRepository roleRepository,
                                                                       UserRepository userRepository,
                                                                       AvailabilityRepository availabilityRepository) {
        return new AbsenceRepositoryEventHandler(roleRepository, userRepository, availabilityRepository);
    }
}
