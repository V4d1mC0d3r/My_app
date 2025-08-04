/*
 Решил разделить интерфейсы учитывая,
 то что у нас разные роли,
 а в разных ролях регистрация и обновления будут разными.

 Сделано, чтобы не было спагетти кода и условий if else,
 с добавлением множества ролей.
*/
package com.example.userservice.service.individual;

import com.example.userservice.dto.IndividualUserCreateDTO;
import com.example.userservice.dto.IndividualUserResponseDTO;
import com.example.userservice.dto.IndividualUserUpdateDTO;
import com.example.userservice.model.enums.UserRoleType;

public interface IndividualUserService {
    IndividualUserResponseDTO createUser(IndividualUserCreateDTO dto, UserRoleType roleType);

    IndividualUserResponseDTO updateUserData(String email, IndividualUserUpdateDTO dto);
}
