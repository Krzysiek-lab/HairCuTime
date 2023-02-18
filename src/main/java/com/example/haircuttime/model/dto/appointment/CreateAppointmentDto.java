package com.example.haircuttime.model.dto.appointment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CreateAppointmentDto {

    private Long userId;

    private LocalDate from;

    private LocalDate to;

    private Long productId;

}
