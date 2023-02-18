package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.appointment.CreateAppointmentDto;
import com.example.haircuttime.model.entity.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentMapper {

    private final UserMapper userMapper;

    private final ProductMapper productMapper;

    public AppointmentDto toDto(Appointment appointment) {
        return AppointmentDto.builder()
                .id(appointment.getId())
                .user(userMapper.toDto(appointment.getUser()))
                .to(appointment.getTo())
                .from(appointment.getFrom())
                .product(productMapper.toDto(appointment.getProduct()))
                .build();
    }


    public Appointment toEntity(AppointmentDto appointmentDto) {
        return Appointment.builder()
                .user(userMapper.toEntity(appointmentDto.getUser()))
                .to(appointmentDto.getTo())
                .from(appointmentDto.getFrom())
                .product(productMapper.toEntity(appointmentDto.getProduct()))
                .build();
    }
    public Appointment toNewEntity(CreateAppointmentDto createDto){
        return Appointment.builder()
                .from(createDto.getFrom())
                .to(createDto.getTo())
                .build();
    }
}
