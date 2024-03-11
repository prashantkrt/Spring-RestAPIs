package com.myLearning.springRest.service;

import com.myLearning.springRest.model.Passenger;

public interface ITicketBookingService {
	
	public Passenger registerPassenger(Passenger passenger);
	
	public Passenger getPassengerInfo(Integer id);

}
