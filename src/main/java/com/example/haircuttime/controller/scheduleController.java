package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.barber.BarberDto;
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
                .filter(e -> e.getBarberDto().getId().equals(barberId))
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
    public WorkYearDto getSchedulesForBarberInYear(@RequestParam Long barberId,
                                                   @RequestParam Long year) {
        return workYearService.getScheduleOfBarber(barberId, year);
    }

    @GetMapping("week")
    public List<WorkDayDto> getDaysInWorkWeek(@RequestParam Long weekId) {
        return workWeekService.getDaysInWorkWeek(weekId);
    }

    @PostMapping("years/add")
    public WorkYearDto addScheduleForBarber(@RequestBody BarberDto barberDto,
                                            @RequestParam long year) {
        return workYearService.addWorkYear(barberDto, year);
    }

    @PostMapping("week/add")
    public WorkYearDto addWorkWeek(@RequestParam Long barberId,
                                   @RequestParam Long year,
                                   @RequestParam Long week) {
        return workYearService.addWorkWeekToYear(barberId, year, week);
    }

}
