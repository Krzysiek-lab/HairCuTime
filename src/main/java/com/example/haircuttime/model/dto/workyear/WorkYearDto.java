package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkYearDto {

    @NotNull
    private Long id;
    @NotNull
    private Long year;

    @JsonIgnore


    @NotNull

    private BarberDto barber;

    private List<WorkDayDto> workDayList = new ArrayList<>();
}
