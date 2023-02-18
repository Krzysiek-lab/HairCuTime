package com.example.haircuttime.model.dto.barber;

import com.example.haircuttime.model.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateBarberDto {
    private String name;
    private String surname;
    private Gender gender;
}
