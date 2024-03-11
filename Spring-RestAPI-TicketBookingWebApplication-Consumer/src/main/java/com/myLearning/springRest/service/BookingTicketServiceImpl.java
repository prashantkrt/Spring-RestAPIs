package com.myLearning.springRest.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.myLearning.springRest.request.Passenger;
import com.myLearning.springRest.response.Ticket;

/*Here we have to consume the data from another rest api*/

@Service
public class BookingTicketServiceImpl implements IBookingTicketService {

	private static final String url1 = "http://localhost:8085/RailwayTicketBookingApplication/ticket/BookingAPI/getTicketNumber";
	private static final String url2 = "http://localhost:8085/RailwayTicketBookingApplication/ticket/BookingAPI/getTicket/{ticketNumber}";


	@Override
	public Ticket bookTicket(Passenger passenger) {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Ticket> responeEntity = restTemplate.postForEntity(url1, passenger, Ticket.class);

		Ticket ticket = responeEntity.getBody();

		return ticket;
	}

	
	@Override
	public Ticket fetchTicketInfo(Integer ticketNumber) {

		RestTemplate template = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = template.getForEntity(url2, Ticket.class, ticketNumber);
		
		return responseEntity.getBody();
	}

}
