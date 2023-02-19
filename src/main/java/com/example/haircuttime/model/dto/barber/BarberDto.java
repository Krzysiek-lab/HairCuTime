package com.example.haircuttime.model.dto.barber;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class BarberDto {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private List<ProductDto> products;

    private List<WorkYearDto> workYears;
    private List<AbsenceDto> absences;
    private List<AvailabilityDto> availabilities;
}
