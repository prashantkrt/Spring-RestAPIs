package com.myLearning.springRest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myLearning.springRest.pojo.Course;
import com.myLearning.springRest.pojo.Implementer;

@RestController // controller + ResponseBody
@RequestMapping("/api/implementers")
public class ImplementerController {

	@GetMapping("/report")
	public ResponseEntity<Implementer> getImplementers() {
		
		Implementer impl = new Implementer();
		impl.setId(1);
		impl.setName("Bazigar");
		impl.setCity("Jalandar");
		impl.setHobbies(new String[] {"Guitar","Painting","Climbing","Playing","Running"});
		impl.setWork(List.of("Developer","Designer","Singing"));
		impl.setCourse(new Course(1,"Java",120.00));

		return new ResponseEntity<>(impl,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveImplementers(@RequestBody Implementer impl)
	{
		System.out.println(impl);
		String body ="Data stored successfully";
		return new ResponseEntity<>(body,HttpStatus.OK);		
	}
}
