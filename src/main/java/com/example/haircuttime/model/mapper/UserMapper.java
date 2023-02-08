package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.user.UserCreateDto;
import com.example.haircuttime.model.dto.user.UserDto;
import com.example.haircuttime.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    //  private final AppointmentMapper appointmentMapper;

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .roles(user.getRoles())
                // .appointmentDtos(getAppointments(user.getAppointments()))
                .build();
    }

   /* private List<AppointmentDto> getAppointments(List<Appointment> appointments) {
        return appointments.stream()
                .map(appointmentMapper::toDto)
                .collect(Collectors.toList);
    }*/

    public User toNewEntity(UserCreateDto createDto) {
        return User.builder()
                .login(createDto.getLogin())
                .password(createDto.getPassword())
                .name(createDto.getName())
                .surname(createDto.getSurname())
                .email(createDto.getEmail()).
                phoneNumber(createDto.getPhoneNumber())
                .build();
    }
}
