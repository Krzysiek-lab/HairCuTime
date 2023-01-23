package com.example.haircuttime.model.dto.workweek;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.schedule.Days;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.TreeMap;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkWeekDto {

    private Long id;
    private Long weekNumber;
    private Map<Days, WorkDayDto> weekAvailability = new TreeMap<>();
}