package com.example.userservice.mapper;

import com.example.userservice.dto.IndividualUserCreateDTO;
import com.example.userservice.dto.IndividualUserResponseDTO;
import com.example.userservice.dto.IndividualUserUpdateDTO;
import com.example.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IndividualUserMapper {
    // Создание нового пользователя из DTO
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "roles", ignore = true) // роли будем добавлять в сервисе
    @Mapping(target = "passwordHash", source = "passwordHash") //Временный пароль(надо сделать логику в AuthService)
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    User toEntity(IndividualUserCreateDTO dto);

    // Возвращаем DTO для профиля
    @Mapping(target = "role", expression = "java(user.getRoles().iterator().next().getRole().name())")
    IndividualUserResponseDTO toResponseDto(User user);

    // Обновление данных пользователя (без изменения email, iin, паспорта и т.д.)
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "iin", ignore = true)
    @Mapping(target = "passportNumber", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "roles", ignore = true)
    void updateEntityFromDto(IndividualUserUpdateDTO dto, @MappingTarget User user);
}
