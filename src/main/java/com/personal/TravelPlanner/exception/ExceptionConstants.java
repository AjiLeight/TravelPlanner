package com.personal.TravelPlanner.exception;

import lombok.Getter;

@Getter
public enum ExceptionConstants {
    EMAIL_EXISTS("EMAIL_EXISTS"),
    TOKEN_EXPIRED("TOKEN_EXPIRED"),
    EMAIL_NOT_FOUND("EMAIL_NOT_FOUND"),
    BAD_CREDENTIALS("BAD_CREDENTIALS"),
    DATA_NOT_FOUND("DATA_NOT_FOUND");

    private final String message;
    ExceptionConstants(String message){
        this.message = message;
    }

}
