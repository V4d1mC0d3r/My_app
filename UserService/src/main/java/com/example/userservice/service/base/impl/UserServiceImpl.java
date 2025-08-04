package com.example.userservice.service.base.impl;

import com.example.userservice.dto.IndividualUserResponseDTO;
import com.example.userservice.mapper.IndividualUserMapper;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.base.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final IndividualUserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, IndividualUserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public IndividualUserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден: " + email));
        return mapper.toResponseDto(user);
    }

    @Override
    public List<IndividualUserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }
}
