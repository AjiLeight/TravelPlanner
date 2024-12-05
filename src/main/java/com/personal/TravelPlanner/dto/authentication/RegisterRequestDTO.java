package com.personal.TravelPlanner.dto.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    private String email;
    @NotBlank(message = "password cannot be blank")
    private String password;
    @NotBlank(message = "role cannot be blank")
    private String role;
}