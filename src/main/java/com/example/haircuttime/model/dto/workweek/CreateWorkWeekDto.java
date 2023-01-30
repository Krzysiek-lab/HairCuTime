package com.example.haircuttime.model.dto.workweek;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
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
public class CreateWorkWeekDto {
    private Long weekNumber;
    private Map<Day, WorkDayDto> weekAvailability = new TreeMap<>();
}
