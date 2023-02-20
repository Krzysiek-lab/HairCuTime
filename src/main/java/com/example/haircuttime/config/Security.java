package com.example.haircuttime.config;

import com.example.haircuttime.service.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class Security {

    private final UserServiceImpl userServiceImpl;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/user/**", "/absence/**", "/barber/**", "/products/**",
                                "/appointment/**", "/workday/**", "/workyear/**", "/workdefinition/**")
                        .hasAuthority("ADMIN")
                        .requestMatchers("/absence", "/absenceByBarber", "/update/absence/{id}").hasAuthority("PERSONNEL")
                        .requestMatchers("/user/add", "/user/delete/{id}", "/user/update",
                                "/products", "/barber/all", "/addAppointment",
                                "/deleteAppointment", "/updateAppointment").hasAuthority("USER")
                        .anyRequest()
                )
                .formLogin()
                .defaultSuccessUrl("http://localhost:3000")
                .failureUrl("/http://localhost:3000:")
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()
                .httpBasic();
        return httpSecurity.build();
    }

    // CZY POTRZEBNE???
    protected void configure(AuthenticationManager authenticationManager) throws Exception {
        authenticationManager.authenticate((Authentication) daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userServiceImpl);
        return provider;
    }


}
