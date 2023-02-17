package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.workyear.CreateWorkYearDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.service.workyear.WorkYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/workyear")
@RequiredArgsConstructor
public class WorkYearController {

    private final WorkYearService workYearService;

    @GetMapping("allWorkYears")
    public List<WorkYearDto> getAllWorkYears() {
        return workYearService.getAllWorkYears();
    }

    @PostMapping("/add")
    public WorkYearDto addWorkYear(
            @RequestBody @Valid CreateWorkYearDto createWorkYearDto) {
        return workYearService.addWorkYear(createWorkYearDto);
    }
}
