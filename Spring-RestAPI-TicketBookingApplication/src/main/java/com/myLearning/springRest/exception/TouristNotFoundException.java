package com.myLearning.springRest.exception;

public class TouristNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TouristNotFoundException() {
		super();
	}

	public TouristNotFoundException(String message) {
		super(message);
	}

}
