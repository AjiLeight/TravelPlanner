package com.personal.TravelPlanner.exception.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmailNotFoundException extends Exception{
    public EmailNotFoundException(String message) {
        super(message);
    }
}
