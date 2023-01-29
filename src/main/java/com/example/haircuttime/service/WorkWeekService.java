package com.example.haircuttime.service;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;

import java.util.List;

public interface WorkWeekService {
    List<WorkDayDto> getDaysInWorkWeek(Long workWeekId);
    WorkWeekDto addWorkWeek(Long weekNumber, BarberDto barberDto);
}
