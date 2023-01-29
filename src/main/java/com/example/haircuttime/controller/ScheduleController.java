package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.service.schedule.WorkWeekServiceImpl;
import com.example.haircuttime.service.schedule.ScheduleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleServiceImpl workYearService;
    private final WorkWeekServiceImpl workWeekService;

    @PostMapping("years")
    public BarberDto addScheduleForBarber(@RequestParam long barberId,
                                            @RequestParam long year) {
        return workYearService.addWorkYear(barberId, year);
    }

//    @GetMapping("years/all")
//    public List<WorkYearDto> getAllSchedules() {
//        return workYearService.getAllSchedules();
//    }
//
//    @GetMapping("years/barber")
//    public List<WorkYearDto> getSchedulesForBarber(@RequestParam Long barberId) {
//        return workYearService.getAllSchedules()
//                .stream()
//                .filter(e -> e.getBarberId().equals(barberId))
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("years/year")
//    public List<WorkYearDto> getSchedulesInYear(@RequestParam Long year) {
//        return workYearService.getAllSchedules()
//                .stream()
//                .filter(e -> e.getYear().equals(year))
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("years/year-barber")
//    public WorkYearDto getSchedulesForBarberInYear(@RequestParam Long barberId,
//                                                   @RequestParam Long year) {
//        return workYearService.getScheduleOfBarber(barberId, year);
//    }
//
//    @GetMapping("week")
//    public List<WorkDayDto> getDaysInWorkWeek(@RequestParam Long weekId) {
//        return workWeekService.getDaysInWorkWeek(weekId);
//    }
//

    @PostMapping("week")
    public BarberDto addWorkWeek(@RequestParam Long barberId,
                                   @RequestParam Long year,
                                   @RequestParam Long week) {
        return workYearService.addWorkWeekToWorkYear(barberId, year, week);
    }

}
