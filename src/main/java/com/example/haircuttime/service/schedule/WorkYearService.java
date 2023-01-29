package com.example.haircuttime.service.schedule;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;

import java.util.List;

public interface WorkYearService {
    WorkYearDto addWorkYear(BarberDto barberDto, Long year);

    WorkYearDto getScheduleOfBarber(Long barberId, Long year);

    List<WorkYearDto> getAllSchedules();

    List<WorkWeekDto> getAllWorkWeeksInYear(Long barberId, Long year);
    WorkYearDto addWorkWeekToYear (Long barberId, Long year, Long week);
}
