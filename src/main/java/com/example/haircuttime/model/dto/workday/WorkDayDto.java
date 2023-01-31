package com.example.haircuttime.model.dto.workday;

import com.example.haircuttime.model.entity.Absence;
import com.example.haircuttime.model.entity.Availability;
import com.example.haircuttime.model.entity.WorkYear;
import com.example.haircuttime.model.enums.WorkDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDayDto {
    private Long id;
    private Long dayInYear;
    private WorkYear workYear;
    private WorkDefinition workDefinition;

    private List<Availability> availabilities = new ArrayList<>();
    private List<Absence> absences = new ArrayList<>();
}
