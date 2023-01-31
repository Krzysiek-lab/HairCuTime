package com.example.haircuttime.service.schedule;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.example.haircuttime.model.enums.WorkDefinition;

public interface ScheduleService {
    BarberDto addWorkYear(Long barberId, Long year);
    BarberDto addWorkDay(Long barberId, Long year, Long dayInYear, WorkDefinition workDefinition);
}
