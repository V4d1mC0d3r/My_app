package com.example.userservice.controller;

import com.example.userservice.dto.IndividualUserResponseDTO;
import com.example.userservice.service.base.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получение пользователя по email
     */
    @GetMapping("/{email}")
    public ResponseEntity<IndividualUserResponseDTO> getUserByEmail(@PathVariable String email) {
        IndividualUserResponseDTO user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    /**
     * Получение всех пользователей
     */
    @GetMapping
    public ResponseEntity<List<IndividualUserResponseDTO>> getAllUsers() {
        List<IndividualUserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Удаление пользователя
     */
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
