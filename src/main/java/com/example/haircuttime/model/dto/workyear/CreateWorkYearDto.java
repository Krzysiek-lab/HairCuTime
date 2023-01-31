package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateWorkYearDto {

    private Long year;
    private Long barberId;
    private List<WorkDayDto> workDayList;

}
