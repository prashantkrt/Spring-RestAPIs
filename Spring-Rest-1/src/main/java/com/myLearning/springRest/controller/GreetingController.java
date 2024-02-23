package com.myLearning.springRest.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // controller + ResponseBody
public class GreetingController {

	@GetMapping("/rest")
	//@ResponseBody
	public ResponseEntity<String> generateGreetings() {

		LocalDateTime time = LocalDateTime.now();
		int hours = time.getHour();
		String body=null;

		if (hours < 12) {
			body= "good morning";
		} else if (hours < 16) {
			body= "good afternoon!!";
		} else if (hours < 20) {
			body= "good evening";
		}
		else
			body= "good night";
		
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}

}
