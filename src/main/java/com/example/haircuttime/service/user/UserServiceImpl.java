package com.example.haircuttime.service.user;

import com.example.haircuttime.EventHandler.AbsenceRepositoryEventHandler;
import com.example.haircuttime.exception.exceptions.UniqueValueException;
import com.example.haircuttime.exception.messages.ExceptionMessages;
import com.example.haircuttime.model.dto.user.CreateUserDto;
import com.example.haircuttime.model.dto.user.UserDto;
import com.example.haircuttime.model.entity.User;
import com.example.haircuttime.model.mapper.UserMapper;
import com.example.haircuttime.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private static final String USER_NOT_FOUND = "user with login %s not found";

    private final AbsenceRepositoryEventHandler repositoryEventHandler;
    private final UserMapper userMapper;


    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDto createUser(CreateUserDto createDto) {
        User user = userMapper.toNewEntity(createDto);
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UniqueValueException(ExceptionMessages.EMAIL_IS_ALREADY_EXIST.getMessage());
        } else if (userRepository.existsByLogin(user.getLogin())) {
            throw new UniqueValueException(ExceptionMessages.LOGIN_IS_ALREADY_EXIST.getMessage());
        }
        repositoryEventHandler.handleUserBeforeCreate(user);
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


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(
                String.format(USER_NOT_FOUND, login)
        ));
    }
    @Override
    public UserDto getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        List<UserDto> users = userRepository.findAll().stream()
                .map(userMapper::toDto).collect(Collectors.toList());
        return findCurrentUser(login, users);
    }
    public UserDto findCurrentUser(String login, List<UserDto> users) {
        List<UserDto> currentUser = new ArrayList<>();
        users.stream()
                .filter(e -> e.getLogin().equals(login))
                .forEach(currentUser::add);
        return currentUser.get(0);
    }

    @Override
    public UserDto getLoggedInUser() {
        var user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userMapper.toDto(user);
    }
}
