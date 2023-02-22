package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.service.workday.WorkDayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workday")
public class WorkDayController {
    public WorkDayController(WorkDayService workDayService) {
        this.workDayService = workDayService;
    }

    private final WorkDayService workDayService;


    @GetMapping("/get")
    public List<WorkDayDto> getAllWorkDays() {
        return workDayService.getAllWorkDays();
    }

    @PostMapping("/create")
    public WorkDayDto addWorkDay(
            @RequestBody CreateWorkDayDto createWorkDayDto) {
        return workDayService.addWorkDay(createWorkDayDto);
    }
}
