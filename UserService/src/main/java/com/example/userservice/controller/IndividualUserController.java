package com.example.userservice.controller;

import com.example.userservice.dto.IndividualUserCreateDTO;
import com.example.userservice.dto.IndividualUserResponseDTO;
import com.example.userservice.dto.IndividualUserUpdateDTO;
import com.example.userservice.model.enums.UserRoleType;
import com.example.userservice.service.individual.IndividualUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/individual")
public class IndividualUserController {

    private final IndividualUserService individualUserService;

    public IndividualUserController(IndividualUserService individualUserService) {
        this.individualUserService = individualUserService;
    }

    @PostMapping
    public ResponseEntity<IndividualUserResponseDTO> registerIndividual(
            @Valid @RequestBody IndividualUserCreateDTO dto) {
        IndividualUserResponseDTO response = individualUserService.createUser(dto, UserRoleType.INDIVIDUAL);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{email}")
    public ResponseEntity<IndividualUserResponseDTO> updateIndividual(
            @PathVariable String email,
            @Valid @RequestBody IndividualUserUpdateDTO dto) {
        IndividualUserResponseDTO updatedUser = individualUserService.updateUserData(email, dto);
        return ResponseEntity.ok(updatedUser);
    }
}
