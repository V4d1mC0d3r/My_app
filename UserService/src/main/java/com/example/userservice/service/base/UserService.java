package com.example.userservice.service.base;

import com.example.userservice.dto.IndividualUserResponseDTO;
import java.util.List;

public interface UserService {
    IndividualUserResponseDTO getUserByEmail(String email);
    List<IndividualUserResponseDTO> getAllUsers();
    void deleteUser(String email);
}
