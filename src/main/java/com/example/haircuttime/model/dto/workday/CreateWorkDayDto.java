package com.example.haircuttime.model.dto.workday;

import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.dto.availability.CreateAvailabilityDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateWorkDayDto {
    @NotNull
    @NotEmpty
    private Long dayInYear;
    @NotNull
    @NotEmpty
    private Long workYearId;
    @NotNull
    @NotEmpty
    private Long workDefinitionId;

    private List<CreateAvailabilityDto> availabilities;
    private List<CreateAbsenceDto> absences;

}

