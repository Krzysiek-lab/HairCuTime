package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.TreeMap;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkYearDto {

    @NotNull
    private Long id;
    @NotNull
    private Long barberId;
    @NotNull
    private Long year;
    private Map<Integer, WorkWeekDto> yearSchedule = new TreeMap<>();

}
