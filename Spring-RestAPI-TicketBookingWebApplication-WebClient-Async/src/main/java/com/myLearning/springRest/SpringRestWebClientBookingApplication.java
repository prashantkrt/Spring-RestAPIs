package com.myLearning.springRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import com.myLearning.springRest.pojo.Ticket;

@SpringBootApplication
public class SpringRestWebClientBookingApplication {

	private static final String url = "http://localhost:8085/RailwayTicketBookingApplication/ticket/BookingAPI/getTicket/{ticketNumber}";

	public static void main(String[] args) {
		SpringApplication.run(SpringRestWebClientBookingApplication.class, args);
		System.out.println("Request to API started!!");

		// get the webclient object
		WebClient webclient = WebClient.create();

		webclient.get().uri(url, 1).retrieve().bodyToMono(Ticket.class)
				.subscribe(SpringRestWebClientBookingApplication::handleRespone);

		System.out.println("Request to API ended....");
		
	}

	public static void handleRespone(Ticket ticket) {
		System.out.println(ticket);
	}
}

/*
 * Request to API started!!
 * Request to API ended....
 *  
 * will not wait for the response and will print -> Request to API ended.... in case of Async
 *  
 * Sync Communication : After sending the request thread will wait or the response before going ahead.
 * Async Communication :After sending the request thread will not wait for the response and it will go ahead with other execution
 *  
 *  
 *  
 *  Sync -> RestTemplate only , RestTemplate is a class 
 *  webClient -> both Sync and Async  webClient is an interface
 *  subscribe is Async and block is Sync
 *  
 * */
