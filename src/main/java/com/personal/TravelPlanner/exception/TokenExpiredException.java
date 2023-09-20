package com.personal.TravelPlanner.exception;

import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class TokenExpiredException extends Exception {
    public TokenExpiredException(String message){
        super(message);
    }
}
