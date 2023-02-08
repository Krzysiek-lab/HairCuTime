package com.example.haircuttime.model.dto.workday;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateWorkDayDto {

    private Long dayInYear;
    private Long workYearId;
    private Long workDefinitionId;

}

