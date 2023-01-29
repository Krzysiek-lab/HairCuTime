package com.example.haircuttime.model.dto.barber;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BarberDto {
    private Long id;
    private String name;
    private String surname;
}
