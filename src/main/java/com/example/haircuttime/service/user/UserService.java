package com.example.haircuttime.service.user;

import com.example.haircuttime.model.dto.user.CreateUserDto;
import com.example.haircuttime.model.dto.user.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto createUser(CreateUserDto createDto);

    UserDto updateUser(UserDto userDto);

    void deleteUserById(Long id);

    UserDto getCurrentUser();

    UserDto getLoggedInUser();

}
