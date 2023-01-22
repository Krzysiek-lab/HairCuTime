package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import lombok.*;

import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkYearDto {

    private Long id;
    private Long barberId;
    private Long year;
    private Map<Integer, WorkWeekDto> yearSchedule= new TreeMap<>();

}
