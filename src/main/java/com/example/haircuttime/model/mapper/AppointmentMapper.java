package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.appointment.CreateAppointmentDto;
import com.example.haircuttime.model.entity.Appointment;
import com.example.haircuttime.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentMapper {

    private final ProductMapper productMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AppointmentDto toDto(Appointment appointment) {
        return AppointmentDto.builder()
                .id(appointment.getId())
                .user(userMapper.toDto(appointment.getUser()))//odkomentowane
                .serviceLength(appointment.getServiceLength())
                .product(productMapper.toDto(appointment.getProduct()))
                .date(appointment.getDate())//dodane
                .time(appointment.getTime())//dodane
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
        var user = userRepository.getReferenceById(createDto.getUserId());//dodane
        return Appointment.builder()
                .date(createDto.getDate())
                .time(createDto.getTime())
                .user(user)//dodane
                .serviceLength(createDto.getServiceLength())
                .build();
    }
}
