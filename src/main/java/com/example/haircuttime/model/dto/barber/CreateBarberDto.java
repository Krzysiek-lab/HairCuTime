package com.example.haircuttime.model.dto.barber;

import com.example.haircuttime.model.enums.Gender;
import com.example.haircuttime.model.enums.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateBarberDto {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private Role role;
}
