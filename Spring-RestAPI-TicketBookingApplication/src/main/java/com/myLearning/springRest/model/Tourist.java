package com.myLearning.springRest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TOURIST")
public class Tourist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TOURIST_ID")
	private Integer touristID;
	@Column(name = "TOURIST_NAME")
	private String touristName;
	@Column(name = "TOURIST_AGE")
	private Integer age;
	@Column(name = "FROM_CITY")
	private String fromCity;
	@Column(name = "TO_CITY")
	private String toCity;
	@Column(name = "TICKET_FARE")
	private Double ticketFare;
	
	public Tourist(String touristName, Integer age, String fromCity, String toCity, Double ticketFare) {
		super();
		this.touristName = touristName;
		this.age = age;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.ticketFare = ticketFare;
	}	
}
