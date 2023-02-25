package com.example.haircuttime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HairCutTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HairCutTimeApplication.class, args);
    }

}
