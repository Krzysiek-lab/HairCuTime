package com.example.haircuttime.service.schedule;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;

import java.util.List;

public interface WorkWeekService {
    List<WorkDayDto> getDaysInWorkWeek(Long workWeekId);
    WorkWeekDto addWorkWeek(Long weekNumber, Long barberId);
}
