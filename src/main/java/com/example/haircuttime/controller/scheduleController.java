package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.service.WorkWeekServiceImpl;
import com.example.haircuttime.service.WorkYearServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/schedule")
@AllArgsConstructor
public class scheduleController {

    private final WorkYearServiceImpl workYearService;
    private final WorkWeekServiceImpl workWeekService;

    @GetMapping("years/all")
    public List<WorkYearDto> getAllSchedules() {
        return workYearService.getAllSchedules();
    }

    @GetMapping("years/barber")
    public List<WorkYearDto> getSchedulesForBarber(@RequestParam Long barberId) {
        return workYearService.getAllSchedules()
                .stream()
                .filter(e -> e.getBarberId().equals(barberId))
                .collect(Collectors.toList());
    }

    @GetMapping("years/year")
    public List<WorkYearDto> getSchedulesInYear(@RequestParam Long year) {
        return workYearService.getAllSchedules()
                .stream()
                .filter(e -> e.getYear().equals(year))
                .collect(Collectors.toList());
    }

    @GetMapping("years/year-barber")
    public WorkYearDto getSchedulesForBarberInYear(@RequestParam Long barberId, @RequestParam Long year) {
        return workYearService.getScheduleOfBarber(barberId, year);
    }

    @PostMapping("years/add")
    public WorkYearDto addScheduleForBarber(@RequestParam Long barberId, @RequestParam long year) {
        return workYearService.addWorkYear(barberId, year);
    }

    @GetMapping("week")
    public List<WorkDayDto> getDaysInWorkWeek (@RequestParam Long weekId){
        return workWeekService.getDaysInWorkWeek(weekId);
    }

    @PostMapping("week/add")
    public WorkYearDto addWorkWeek (@RequestParam Long workWeek, @RequestParam Long barberId, @RequestBody WorkWeekDto workWeekDto) {
        return workYearService.addWorkWeekToYear(barberId, workWeek, workWeekDto);
    }

}
