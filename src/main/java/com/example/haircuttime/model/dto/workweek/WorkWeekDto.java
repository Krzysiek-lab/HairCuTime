package com.example.haircuttime.model.dto.workweek;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.enums.Day;
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
    private Long barberId;
    private Long weekNumber;
    private Map<Day, WorkDayDto> weekAvailability = new TreeMap<>();
}
