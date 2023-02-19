package com.example.haircuttime.model.dto.absence;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Builder
@Getter
@Setter
public class CreateAbsenceDto {
    //@NotNull
   // @NotEmpty
    private Long barberId;

   // @NotNull
    //@NotEmpty
    private Long workDayId;

    //@NotNull
   //@NotEmpty
    private LocalTime absenceStart;

   // @NotNull
    //@NotEmpty
    private LocalTime absenceEnd;
}
