package com.example.haircuttime.service.user;

import com.example.haircuttime.model.dto.user.UserCreateDto;
import com.example.haircuttime.model.dto.user.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserDto createUser(UserCreateDto createDto);

    UserDto updateUser(UserDto userDto);

    void deleteUserById(Long id);

}
