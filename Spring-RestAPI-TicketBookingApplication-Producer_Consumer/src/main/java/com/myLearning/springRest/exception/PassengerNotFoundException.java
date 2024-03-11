package com.myLearning.springRest.exception;

public class PassengerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PassengerNotFoundException() {
		super();
	}

	public PassengerNotFoundException(String message) {
		super(message);
	}

}
