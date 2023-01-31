package com.example.haircuttime.model.dto.appointment;

import com.example.haircuttime.model.entity.Product;
import com.example.haircuttime.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AppointmentDto {

    @DateTimeFormat
    private LocalDate from;
    @NotNull
    private User userId;
    @DateTimeFormat
    private LocalDate to;
    private Product product;
}
