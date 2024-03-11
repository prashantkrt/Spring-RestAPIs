package com.myLearning.springRest.advice;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.myLearning.springRest.exception.PassengerNotFoundException;

@RestControllerAdvice
public class TouristErrorController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleExceptionsGlobally(Exception e) {

		ErrorDetails error = new ErrorDetails("404 Not Found", e.getMessage(), LocalDateTime.now());

		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(PassengerNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleExceptionForTourist(PassengerNotFoundException e) {

		ErrorDetails error = new ErrorDetails("404 Not Found", e.getMessage(), LocalDateTime.now());

		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}

}
