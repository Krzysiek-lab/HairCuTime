package com.example.haircuttime.config;

import com.example.haircuttime.service.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class Security {

    private final UserServiceImpl userServiceImpl;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //TODO DODAC ODPOWIEDNIE ENDPOINTY I ROLE DO FILTERCHAIN'A
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable().authorizeHttpRequests()
//                .requestMatchers("")
//                .hasRole("ADMIN")
//                .requestMatchers("")
//                .permitAll()
//                .requestMatchers("")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
                .and()
                .formLogin()
//                .defaultSuccessUrl("http://localhost:3000")
//                .failureUrl("/http://localhost:3000:/home")
                .and()
                .logout().permitAll()
                .and()
                .httpBasic();

        return httpSecurity.build();
    }

    //CZY POTRZEBNE???
//    protected void configure(AuthenticationManager authenticationManager) throws Exception {
//        authenticationManager.authenticate((Authentication) daoAuthenticationProvider());
//    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userServiceImpl);
        return provider;
    }


}
