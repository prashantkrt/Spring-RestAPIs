package com.myLearning.springRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myLearning.springRest.pojo.Implementer;

//@Controller
@RestController // controller + ResponseBody
@RequestMapping("/api")
public class TestController {

	@GetMapping("/api1")
	public Implementer generateGreetings() {
		Implementer impl = new Implementer();
		impl.setId(1);
		impl.setName("Bazigar");
		impl.setCity("Jalandar");
		
		return impl; // it will be in json format which makes very easy to integrate with other applications
		//JACKSON API is used to convert java object to json and json to java object
		//JSON is universal
		//JACKSON is specific to Java only
	}
}
