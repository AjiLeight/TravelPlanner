package com.personal.TravelPlanner.exception.room;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateRoomException extends Exception{
    public DuplicateRoomException(String message) {
        super(message);
    }
}
