package com.personal.TravelPlanner.dto;

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
    @NotBlank(message = "firstname cannot be blank")
    private String firstname;
    @NotBlank(message = "lastname cannot be blank")
    private String lastname;
    @Email(message = "enter a valid email")
    private String email;
    @NotBlank(message = "password cannot be blank")
    private String password;
    @NotBlank(message = "role cannot be blank")
    private String role;
}