package com.example.haircuttime.model.dto.availability;


import com.example.haircuttime.model.schedule.WorkDay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAvailabilityDto {

    private WorkDay workDay;
    private Long barberId;

}
