package com.example.haircuttime.model.dto.workday;

import com.example.haircuttime.model.dto.workdefinition.WorkDefinitionDto;
import com.example.haircuttime.model.entity.WorkYear;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkDayDto {
    private Long dayInYear;
    private WorkYear workYear;
    private WorkDefinitionDto workDefinitionDto;
}
