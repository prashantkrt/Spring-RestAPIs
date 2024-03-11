package com.myLearning.springRest.service;

import com.myLearning.springRest.request.Passenger;
import com.myLearning.springRest.response.Ticket;

public interface IBookingTicketService {

	public Ticket bookTicket(Passenger passenger);

	public Ticket fetchTicketInfo(Integer ticketNumber);
}
