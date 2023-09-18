package com.personal.TravelPlanner.controller;

import com.personal.TravelPlanner.dto.AuthenticationRequestDTO;
import com.personal.TravelPlanner.dto.AuthenticationResponseDTO;
import com.personal.TravelPlanner.dto.RegisterRequestDTO;
import com.personal.TravelPlanner.exception.EmailAlreadyExistsException;
import com.personal.TravelPlanner.repository.UserRepository;
import com.personal.TravelPlanner.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestDTO request) throws Exception {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already in use");
        }
        return  ResponseEntity.ok(service.register(request));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody AuthenticationRequestDTO request){

        return  ResponseEntity.ok(service.authenticate(request));
        //
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }


}
