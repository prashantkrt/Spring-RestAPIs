package com.myLearning.springRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myLearning.springRest.request.Passenger;
import com.myLearning.springRest.response.Ticket;
import com.myLearning.springRest.service.IBookingTicketService;

@Controller
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private IBookingTicketService service;

	@PostMapping("/ticket")
	public String bookTicket(@ModelAttribute Passenger passenger, Model model) {
		System.out.println("Passengers from form " + passenger);
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("ticketNumber", "Ticket number is " + ticket.getTicketNumber());
		return "index";
	}

	@GetMapping("/form")
	public String getIndexPage(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";
	}

	@GetMapping("/ticket")
	public String getTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticket";
	}

	@GetMapping("/ticketDetail")
	public String getTicketForm(@RequestParam(value = "ticketNo", required = false) Integer ticketNumber, Model model) {
		System.out.println("Working fine");
		if (ticketNumber != null) {
			Ticket ticket = service.fetchTicketInfo(ticketNumber);
			System.out.println(ticket);
			model.addAttribute("ticket", ticket);
			return "ticket";
		} else {
			model.addAttribute("ticket", new Ticket());
			return "ticketData";
		}
	}
}
