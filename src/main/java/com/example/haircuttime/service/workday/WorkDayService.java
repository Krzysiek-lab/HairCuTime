package com.example.haircuttime.service.workday;

import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;

import java.util.List;

public interface WorkDayService {

    List<WorkDayDto> getAllWorkDays();
    WorkDayDto addWorkDay(CreateWorkDayDto createWorkDayDto);
}
