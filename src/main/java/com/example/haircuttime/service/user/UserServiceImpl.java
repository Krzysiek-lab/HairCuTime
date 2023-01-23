package com.example.haircuttime.service.user;

import com.example.haircuttime.model.dto.user.UserCreateDto;
import com.example.haircuttime.model.dto.user.UserDto;
import com.example.haircuttime.model.entity.User;
import com.example.haircuttime.model.mapper.UserMapper;
import com.example.haircuttime.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDto createUser(UserCreateDto createDto) {
        User user = userMapper.toNewEntity(createDto);
        return userMapper.toDto(userRepository.save(user));
    }


    @Override
    @Transactional
    public UserDto updateUser(UserDto userDto) {
        return userRepository.findById(userDto.getId()).map(user -> {
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            user.setEmail(userDto.getEmail());
           user.setPhoneNumber(userDto.getPhoneNumber());
            return userMapper.toDto(user);
        }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
