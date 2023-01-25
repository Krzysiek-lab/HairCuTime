package com.example.haircuttime.mapper;

import com.example.haircuttime.dto.AppointmentDto;
import com.example.haircuttime.model.Appointment;
import org.springframework.stereotype.Service;

@Service
public class AppointmentMapper {

    public AppointmentDto mapperDto(Appointment appointment) {
        return AppointmentDto.builder()
                .userId(appointment.getUserId())
                .to(appointment.getTo())
                .from(appointment.getFrom())
                .product(appointment.getProduct())
                .build();
    }


    public Appointment mapper(AppointmentDto appointmentDto) {
        return Appointment.builder()
                .userId(appointmentDto.getUserId())
                .to(appointmentDto.getTo())
                .from(appointmentDto.getFrom())
                .product(appointmentDto.getProduct())
                .build();
    }
}
