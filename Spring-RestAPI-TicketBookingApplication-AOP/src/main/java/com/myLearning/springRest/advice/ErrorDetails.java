package com.myLearning.springRest.advice;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {

	private String statusCode;
	private String message;
	private LocalDateTime when;

}
