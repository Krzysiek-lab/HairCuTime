package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateWorkYearDto {

    private Long year;
    @JsonIgnore
    private Long barberId;
    private List<CreateWorkDayDto> workDayList;

}