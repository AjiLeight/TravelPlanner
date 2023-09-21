package com.personal.TravelPlanner.service.authentication;

import com.personal.TravelPlanner.dto.authentication.AuthenticationRequestDTO;
import com.personal.TravelPlanner.dto.authentication.AuthenticationResponseDTO;
import com.personal.TravelPlanner.dto.authentication.RegisterRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticationService {

    AuthenticationResponseDTO register(RegisterRequestDTO request);
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
     void refreshToken (
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception;
}
