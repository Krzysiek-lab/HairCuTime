package com.example.haircuttime.model.dto.workday;

import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.dto.availability.CreateAvailabilityDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateWorkDayDto {
    @Max(365)
    @NonNull
    private Long dayInYear;
    @NotNull
    private Long workYearId;
    @NotNull
    private Long workDefinitionId;

    private List<CreateAvailabilityDto> availabilities;
    private List<CreateAbsenceDto> absences;

}

