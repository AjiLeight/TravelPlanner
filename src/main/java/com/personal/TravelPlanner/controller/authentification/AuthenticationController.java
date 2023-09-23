package com.personal.TravelPlanner.controller.authentification;

import com.personal.TravelPlanner.dto.authentication.AuthenticationRequestDTO;
import com.personal.TravelPlanner.dto.authentication.AuthenticationResponseDTO;
import com.personal.TravelPlanner.dto.authentication.RegisterRequestDTO;
import com.personal.TravelPlanner.exception.auth.EmailAlreadyExistsException;
import com.personal.TravelPlanner.repository.UserRepository;
import com.personal.TravelPlanner.service.authentication.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@Valid
            @RequestBody RegisterRequestDTO request) throws Exception {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already in use");
        }
        return  ResponseEntity.ok(service.register(request));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@Valid @RequestBody AuthenticationRequestDTO request){

        return  ResponseEntity.ok(service.authenticate(request));
        //
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {
        service.refreshToken(request, response);
    }


}
