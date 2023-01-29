package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkYearDto {

    @NotNull
    private Long id;
    @NotNull
    private BarberDto barberDto;
    @NotNull
    private Long year;
    private Map<Integer, WorkWeekDto> yearSchedule = new TreeMap<>();

    public WorkWeekDto addWorkWeek(WorkWeekDto workWeekDto) {
        return yearSchedule.put(Math.toIntExact(workWeekDto.getWeekNumber()), workWeekDto);
    }
}
