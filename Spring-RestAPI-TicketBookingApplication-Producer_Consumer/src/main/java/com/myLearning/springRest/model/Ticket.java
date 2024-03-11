package com.myLearning.springRest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ticket")
public class Ticket {

	@Id
	@Column(name = "Ticket_Number")
	private Integer ticketNumber;

	private String status;

	@Column(name = "Fare")
	private Double totalFare;

	private String name;

	private String departure;

	private String arrival;

	@Column(name = "Date_Of_Journey")
	private String dateOfJourney;
}
