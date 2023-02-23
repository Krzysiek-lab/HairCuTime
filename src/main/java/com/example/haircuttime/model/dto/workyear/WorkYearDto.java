package com.example.haircuttime.model.dto.workyear;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

    @NotNull
    @JsonIgnore
    private BarberDto barber;

    private List<WorkDayDto> workDayList = new ArrayList<>();
}
