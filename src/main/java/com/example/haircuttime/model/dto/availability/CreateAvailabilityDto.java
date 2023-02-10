package com.example.haircuttime.model.dto.availability;


import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.entity.WorkDay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAvailabilityDto {

    @NotNull
    @NotEmpty
    private WorkDay workDay;

    @NotNull
    @NotEmpty
    private BarberDto barberDto;

}
