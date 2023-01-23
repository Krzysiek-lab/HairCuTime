package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.user.UserCreateDto;
import com.example.haircuttime.model.dto.user.UserDto;
import com.example.haircuttime.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto (User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .roles(user.getRoles())
                .build();
    }
    public User toNewEntity (UserCreateDto createDto){
        return User.builder()
                .login(createDto.getLogin())
                .password(createDto.getPassword())
                .name(createDto.getName())
                .surname(createDto.getSurname())
                .email(createDto.getEmail())
                .phoneNumber(createDto.getPhoneNumber())
                .roles(createDto.getRoles())
                .build();
    }
}
