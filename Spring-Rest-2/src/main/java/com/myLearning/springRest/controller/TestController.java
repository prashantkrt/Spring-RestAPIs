package com.myLearning.springRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // controller + ResponseBody
@RequestMapping("/api")
public class TestController {

	// single call only once bean is created
	// will not be called multiple times for every request hit
	public TestController() {
		System.out.println("GreetingController bean is created!!");
	}

	@GetMapping("/welcome")
	public String generateGreetings() {
		String body = "Hello World";
		return body;
	}
	
	//http://localhost:8085/api/welcome2?name=abc
	//http://localhost:8085/api/welcome2?name=abc&city=Gurgaon
	@GetMapping("/welcome2")
	public String generateWelcomeMessage(@RequestParam("name") String name) {
		String body = "Hello "+name;
		return body;		
	}
	//http://localhost:8085/api/welcome3?name=abc&city=Gurgaon
	@GetMapping("/welcome3")
	public String generateWelcomeMessage(@RequestParam("name") String name, @RequestParam() String city) {
		String body = "Hello "+name+" from "+city;
		return body;		
	}
	@GetMapping("/welcome31")
	public String generateWelcome(@RequestParam() String name, @RequestParam() String city) {
		String body = "Hello "+name+" from "+city;
		return body;		
	}
	
	//http://localhost:8085/api/welcome4
	//http://localhost:8085/api/welcome4?name=abc
	@GetMapping("/welcome4")
	public String generateMessage(@RequestParam(value = "name", required = false) String name) {
		String body = "Hello "+name;
		return body;		
	}
	
	//http://localhost:8085/api/welcome5
	@GetMapping("/welcome5")
	public String generateMessageDefault(@RequestParam(value = "name", required = false,defaultValue = "XYZ") String name) {
		String body = "Hello "+name;
		return body;		
	}
	//http://localhost:8085/api/welcome6/Ajay/Dehradun
	@GetMapping("/welcome6/{name}/{city}")
	public String messagePathParam(@PathVariable(value = "name") String n, @PathVariable(value="city")String c) {
		String body = "Hello "+n+" from "+c;
		return body;		
	}
	
	//if name is in paramter is same as defined no need to add in @PathVariable
	@GetMapping("/welcome7/{name}/{city}")
	public String messagePathParam2(@PathVariable() String name, @PathVariable()String city) {
		String body = "Hello "+name+" from "+city;
		return body;		
	}

}
