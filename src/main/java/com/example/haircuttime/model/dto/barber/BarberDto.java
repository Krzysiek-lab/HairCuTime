package com.example.haircuttime.model.dto.barber;

import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.*;
import com.example.haircuttime.model.enums.Gender;
import com.example.haircuttime.model.enums.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BarberDto {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;

    private List<Product> products;
    private List<WorkYearDto> workYears;

}
