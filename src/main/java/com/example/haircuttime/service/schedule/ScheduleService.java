package com.example.haircuttime.service.schedule;

import com.example.haircuttime.model.dto.barber.BarberDto;

public interface ScheduleService {
    BarberDto addWorkYear(Long barberId, Long year);
    BarberDto addWorkWeekToWorkYear(Long barberId, Long year, Long weekNumber);

//    WorkYearDto getScheduleOfBarber(Long barberId, Long year);
//
//    List<WorkYearDto> getAllSchedules();
//
//    List<WorkWeekDto> getAllWorkWeeksInYear(Long barberId, Long year);
//    WorkYearDto addWorkWeekToYear (Long barberId, Long year, Long week);
}
