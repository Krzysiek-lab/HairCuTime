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
                //.user(userMapper.toDto(appointment.getUser()))
                .serviceLength(appointment.getServiceLength())
                .product(productMapper.toDto(appointment.getProduct()))
                .build();
    }


    public Appointment toEntity(AppointmentDto appointmentDto) {
        return Appointment.builder()
                //.user(userMapper.toEntity(appointmentDto.getUser()))
                .serviceLength(appointmentDto.getServiceLength())
                .product(productMapper.toEntity(appointmentDto.getProduct()))
                .build();
    }

    public Appointment toNewEntity(CreateAppointmentDto createDto) {
        return Appointment.builder()
                .serviceLength(createDto.getServiceLength())
                .build();
    }
}
