package com.example.haircuttime.service.workyear;

import com.example.haircuttime.model.dto.workyear.CreateWorkYearDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;

import java.util.List;

public interface WorkYearService {

    List<WorkYearDto> getAllWorkYears();

    WorkYearDto addWorkYear(CreateWorkYearDto createWorkYearDto);
}
