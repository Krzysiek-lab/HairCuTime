package com.example.haircuttime.model.dto.workday;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.workdefinition.WorkDefinitionDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkDayDto {
    @NotNull
    @NotEmpty
    private Long id;
    @NotNull
    @NotEmpty
    private Long dayInYear;
    @NotNull
    @NotEmpty
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

