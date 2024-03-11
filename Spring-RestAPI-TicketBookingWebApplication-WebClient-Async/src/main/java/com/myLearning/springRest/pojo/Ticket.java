package com.myLearning.springRest.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*POJO*/

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

	private Integer ticketNumber;

	private String status;

	private Double totalFare;

	private String name;

	private String departure;

	private String arrival;

	private String dateOfJourney;
}
