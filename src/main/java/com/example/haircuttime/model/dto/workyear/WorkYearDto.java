package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkYearDto {

    private Long id;
    private Long year;
    private Long barberId;
    private List<WorkDayDto> workDayList = new ArrayList<>();
}
