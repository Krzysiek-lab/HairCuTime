package com.example.haircuttime.service;

import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;

import java.util.List;

public interface WorkYearService {
    WorkYearDto addWorkYear(Long barberId, Long year);

    WorkYearDto getScheduleOfBarber(Long barberId, Long year);

    List<WorkYearDto> getAllSchedules();

    List<WorkWeekDto> getAllWorkWeeksInYear(Long barberId, Long year);
}