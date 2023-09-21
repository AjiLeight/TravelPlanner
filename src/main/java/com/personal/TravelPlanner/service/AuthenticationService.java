package com.personal.TravelPlanner.service;

import com.personal.TravelPlanner.dto.AuthenticationRequestDTO;
import com.personal.TravelPlanner.dto.AuthenticationResponseDTO;
import com.personal.TravelPlanner.dto.RegisterRequestDTO;
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
