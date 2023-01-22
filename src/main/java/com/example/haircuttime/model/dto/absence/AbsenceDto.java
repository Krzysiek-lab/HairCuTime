package com.example.haircuttime.model.dto.absence;

import com.example.haircuttime.model.schedule.WorkDay;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Builder
@Getter
@Setter
public class AbsenceDto {
    private Long id;
    private WorkDay workDay;
    private Long barberId;
    private LocalTime absenceStart;
    private LocalTime absenceEnd;
}
