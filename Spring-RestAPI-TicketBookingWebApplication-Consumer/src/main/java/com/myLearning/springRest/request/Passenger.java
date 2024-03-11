package com.myLearning.springRest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * POJO
 * 
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

	private Integer passengerId;

	private String passengerName;

	private Integer age;

	private String departure;

	private String arrival;

	private String dateOfJourney;

	public Passenger(String passengerName, Integer age, String departure, String arrival, String dateOfJourney) {
		super();
		this.passengerName = passengerName;
		this.age = age;
		this.departure = departure;
		this.arrival = arrival;
		this.dateOfJourney = dateOfJourney;
	}
}