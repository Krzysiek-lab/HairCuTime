package com.example.haircuttime.service.schedule;

import com.example.haircuttime.model.dto.barber.BarberDto;

public interface ScheduleService {
    BarberDto addWorkYear(Long barberId, Long year);
    BarberDto addWorkDay(Long barberId, Long year, Long dayInYear, String workDefinitionName);
}
