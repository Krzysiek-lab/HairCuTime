package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.entity.WorkDay;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkYearDto {

    private Long id;
    private Long year;
    private Long barberId;
    private List<WorkDayDto> workDayList;

}
