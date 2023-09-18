package com.personal.TravelPlanner.controller;

import com.personal.TravelPlanner.dto.AuthenticationRequestDTO;
import com.personal.TravelPlanner.dto.AuthenticationResponseDTO;
import com.personal.TravelPlanner.dto.RegisterRequestDTO;
import com.personal.TravelPlanner.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestDTO request){
        return  ResponseEntity.ok(service.register(request));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody AuthenticationRequestDTO request){

        return  ResponseEntity.ok(service.authenticate(request));
        //
    }


}
