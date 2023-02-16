package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.workyear.CreateWorkYearDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.service.workyear.WorkYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workyear")
@RequiredArgsConstructor
public class WorkYearController {

    private final WorkYearService workYearService;

    @GetMapping
    public List<WorkYearDto> getAllWorkYears() {
        return workYearService.getAllWorkYears();
    }

    @PostMapping
    public WorkYearDto addWorkYear(
            @RequestBody CreateWorkYearDto createWorkYearDto) {
        return workYearService.addWorkYear(createWorkYearDto);
    }
}
