package com.myLearning.springRest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)// this required if POJO doesn't have extra contect which we are passing in JSON
public class Implementer{	

	private Integer id;
	private String name;
	private String city;
	private String [] hobbies;
	private List<String> work;
	private Course course;

}
