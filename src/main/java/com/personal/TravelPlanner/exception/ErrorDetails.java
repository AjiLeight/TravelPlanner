package com.personal.TravelPlanner.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ErrorDetails {
	
	private String timestamp;
	private String message;
	private String details;
}
