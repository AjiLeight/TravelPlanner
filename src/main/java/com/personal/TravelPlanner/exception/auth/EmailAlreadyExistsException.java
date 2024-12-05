package com.personal.TravelPlanner.exception.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EmailAlreadyExistsException extends Exception{

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
