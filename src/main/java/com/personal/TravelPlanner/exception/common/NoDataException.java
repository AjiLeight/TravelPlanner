package com.personal.TravelPlanner.exception.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NoDataException extends Exception {
    public NoDataException(String message) {
        super(message);
    }
}
