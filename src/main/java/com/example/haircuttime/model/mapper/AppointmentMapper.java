package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.appointment.CreateAppointmentDto;
import com.example.haircuttime.model.entity.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentMapper {

    private final ProductMapper productMapper;

    public AppointmentDto toDto(Appointment appointment) {
        return AppointmentDto.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .time(appointment.getTime())
                .serviceLength(appointment.getServiceLength())
                .product(productMapper.toDto(appointment.getProduct()))
                .build();
    }


    public Appointment toEntity(AppointmentDto appointmentDto) {
        return Appointment.builder()
                .id(appointmentDto.getId())
                .date(appointmentDto.getDate())
                .time(appointmentDto.getTime())
                .serviceLength(appointmentDto.getServiceLength())
                .product(productMapper.toEntity(appointmentDto.getProduct()))
                .build();
    }

    public Appointment toNewEntity(CreateAppointmentDto createDto) {
        return Appointment.builder()
                .date(createDto.getDate())
                .time(createDto.getTime())
                .build();
    }
}
