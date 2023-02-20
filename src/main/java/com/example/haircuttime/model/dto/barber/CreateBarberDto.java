package com.example.haircuttime.model.dto.barber;

import com.example.haircuttime.model.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;


@Builder
@Getter
@Setter
public class CreateBarberDto {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String surname;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
