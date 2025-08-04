package com.example.userservice.service.individual.impl;

import com.example.userservice.dto.IndividualUserCreateDTO;
import com.example.userservice.dto.IndividualUserResponseDTO;
import com.example.userservice.dto.IndividualUserUpdateDTO;
import com.example.userservice.mapper.IndividualUserMapper;
import com.example.userservice.model.User;
import com.example.userservice.model.UserRole;
import com.example.userservice.model.enums.UserRoleType;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.individual.IndividualUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Transactional
public class IndividualUserServiceImpl implements IndividualUserService {
/*
* Убрал Optional чтобы не дублировать проверку:
* userService.getUserByEmail(email)
        .orElseThrow(() -> new RuntimeException("Не найден"));
   Так как выбросил уже исключение - throw new RuntimeException("Пользователь не найден"))
* */

    private final UserRepository userRepository;
    private final IndividualUserMapper mapper;

    public IndividualUserServiceImpl(UserRepository userRepository, IndividualUserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public IndividualUserResponseDTO createUser(IndividualUserCreateDTO dto, UserRoleType roleType) {
        User user = mapper.toEntity(dto);

        // назначаем роль внутри сервиса
        UserRole userRole = new UserRole(user, roleType);
        user.setRoles(Collections.singleton(userRole));

        User savedUser = userRepository.save(user);
        return mapper.toResponseDto(savedUser);
    }

    @Override
    public IndividualUserResponseDTO updateUserData(String email, IndividualUserUpdateDTO dto) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Пользователь с email " + email + " не найден"));

        mapper.updateEntityFromDto(dto, user);
        User updatedUser = userRepository.save(user);

        return mapper.toResponseDto(updatedUser);
    }
}
