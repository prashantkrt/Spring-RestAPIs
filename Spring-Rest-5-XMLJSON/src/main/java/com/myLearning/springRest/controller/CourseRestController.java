package com.myLearning.springRest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.myLearning.springRest.pojo.Course;

@RestController
public class CourseRestController {

	// produces = "application/json" by default
	// wants to enable for both xml and json produces
	// produces ={"application/xml","application/json"}
	@GetMapping(value = "/getCourse", produces = { "application/xml", "application/json" })
	public Course getCourse() {
		Course course = new Course();
		course.setId(1);
		course.setName("ABC");
		course.setPrice(123.00);
		return course;
	}

	// fexible for both Json and Xml
	// wants to enable for both xml and json produces
	// consumes ={"application/xml","application/json"}
	@PostMapping(value = "/addCourse", consumes = { "application/xml", "application/json" })
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		System.out.println(course);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

}
