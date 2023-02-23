package com.example.haircuttime.model.dto.workday;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.workdefinition.WorkDefinitionDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.WorkYear;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkDayDto {
    @NotNull
    private Long id;
    @NotNull

    private Long dayInYear;
    @NotNull
    @NotEmpty
    @Max(365)
    @JsonIgnore
    private WorkYearDto workYear;
    @NotNull
    @NotEmpty
    private WorkDefinitionDto workDefinition;
    @NotNull
    @NotEmpty
    private List<AvailabilityDto> availabilities;
    @NotNull
    @NotEmpty
    private List<AbsenceDto> absences;
}

