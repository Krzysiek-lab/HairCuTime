package com.example.haircuttime.model.dto.barber;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.*;
import com.example.haircuttime.model.enums.Gender;
import com.example.haircuttime.model.enums.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BarberDto {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private Role role;
    List<Product> products;
    private List<AbsenceDto> absences;
    private List<AvailabilityDto> availabilityList;
    private List<WorkYearDto> workYears;
    private List<WorkWeekDto> workWeeks;
    private List<WorkDayDto> workDays;
}
