package com.myLearning.springRest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "PASSENGER_DETAILS")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PASSENGER_ID")
	private Integer passengerId;
	@Column(name = "PASSENGER_NAME")
	private String passengerName;
	@Column(name = "PASSENGER_AGE")
	private Integer age;
	@Column(name = "DEPARTURE")
	private String departure;
	@Column(name = "ARRIVAL")
	private String arrival;
	@Column(name = "JOURNEY_DATE")
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
