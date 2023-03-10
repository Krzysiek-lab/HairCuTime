package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
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