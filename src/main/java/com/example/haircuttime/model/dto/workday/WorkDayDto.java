package com.example.haircuttime.model.dto.workday;

import com.example.haircuttime.model.entity.Absence;
import com.example.haircuttime.model.entity.Availability;
import com.example.haircuttime.model.entity.WorkDefinition;
import com.example.haircuttime.model.entity.WorkYear;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class WorkDayDto {
    private Long id;
    private Long dayInYear;
    private WorkYear workYear;
    private WorkDefinition workDefinition;

    private List<Availability> availabilities;
    private List<Absence> absences;
}
