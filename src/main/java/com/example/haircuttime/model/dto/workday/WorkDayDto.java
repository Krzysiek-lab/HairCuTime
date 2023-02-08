package com.example.haircuttime.model.dto.workday;

import com.example.haircuttime.model.dto.workdefinition.WorkDefinitionDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.Absence;
import com.example.haircuttime.model.entity.Availability;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkDayDto {
    private Long id;
    private Long dayInYear;
    private WorkYearDto workYear;
    private WorkDefinitionDto workDefinition;
    private List<Availability> availabilities;
    private List<Absence> absences;
}

