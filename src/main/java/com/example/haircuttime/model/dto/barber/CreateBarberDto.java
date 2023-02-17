package com.example.haircuttime.model.dto.barber;

import com.example.haircuttime.model.enums.Gender;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Data
public class CreateBarberDto {
    //    @NotNull
//    @NotEmpty
    private String name;
    //    @NotNull
//    @NotEmpty
    private String surname;

    //    @NotNull
//    @NotEmpty
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
