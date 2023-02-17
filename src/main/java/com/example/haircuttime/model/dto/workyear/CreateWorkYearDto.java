package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateWorkYearDto {

    @NotNull
    private Long year;
    @NotNull
    private Long barberId;
    private List<CreateWorkDayDto> workDayList;
}