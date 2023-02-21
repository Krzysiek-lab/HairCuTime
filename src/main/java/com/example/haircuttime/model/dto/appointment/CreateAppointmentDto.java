package com.example.haircuttime.model.dto.appointment;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateAppointmentDto {

    private Long userId;

    @NotNull
    private Long serviceLength;

    @NotNull
    private Long productId;

}
