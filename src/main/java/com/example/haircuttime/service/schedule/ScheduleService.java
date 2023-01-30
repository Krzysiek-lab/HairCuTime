package com.example.haircuttime.service.schedule;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workweek.CreateWorkWeekDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;

public interface ScheduleService {
    BarberDto addWorkYear(Long barberId, Long year);
    BarberDto addEmptyWorkWeekToWorkYear(Long barberId, Long year, Long weekNumber);

    BarberDto addWorkWeekToWorkYear(Long barberId, Long year, CreateWorkWeekDto createWorkWeekDto);

//    WorkYearDto getScheduleOfBarber(Long barberId, Long year);
//
//    List<WorkYearDto> getAllSchedules();
//
//    List<WorkWeekDto> getAllWorkWeeksInYear(Long barberId, Long year);
//    WorkYearDto addWorkWeekToYear (Long barberId, Long year, Long week);
}