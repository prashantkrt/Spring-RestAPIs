package com.myLearning.springRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myLearning.springRest.dao.ITicketRepository;
import com.myLearning.springRest.model.Passenger;

@Service
public class TicketBookingServiceImpl implements ITicketBookingService {

	@Autowired
	private ITicketRepository repo;

	@Override
	public Passenger registerPassenger(Passenger passenger) {	
		return repo.save(passenger);
	}

	@Override
	public Passenger getPassengerInfo(Integer id) {
		return repo.findById(id).get();
	}
}
