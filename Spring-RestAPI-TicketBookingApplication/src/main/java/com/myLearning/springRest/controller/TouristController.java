package com.myLearning.springRest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.myLearning.springRest.exception.TouristNotFoundException;
import com.myLearning.springRest.model.Tourist;
import com.myLearning.springRest.service.TouristService;

@RestController
public class TouristController {

	@Autowired
	private TouristService service;

	@PostMapping("/enroll")
	public ResponseEntity<String> entrollTourist(@RequestBody Tourist tourist) {
		try {
			return new ResponseEntity<>(service.regsiterTourist(tourist), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/enrollAll")
	public ResponseEntity<?> entrollAllTourist(@RequestBody List<Tourist> tourist) {
		try {
			return new ResponseEntity<>(service.regsiterAllTourist(tourist), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getTourist")
	public ResponseEntity<?> getTourist(@RequestParam Integer id) {
		try {
			return new ResponseEntity<Tourist>(service.fetchTourist(id), HttpStatus.OK);
		} catch (TouristNotFoundException tn) {
			return new ResponseEntity<>(tn.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAllTourist")
	public ResponseEntity<List<?>> getAllTourists() {
		try {
			return new ResponseEntity<List<?>>(service.getAllTourist(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<?>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateTourist") // update maximum data or larger or entire record
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist) {
		try {
			return new ResponseEntity<String>(service.updateTourist(tourist), HttpStatus.OK);
		} catch (TouristNotFoundException tn) {
			throw new TouristNotFoundException(tn.getMessage());
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/partailUpdateTouristFare/{id}/{budget}") // update minimun data or smaller/partially changes
	public ResponseEntity<String> updateTouristFare(@PathVariable("id") Integer touristId,
			@PathVariable("budget") Double fare) {
		try {
			return new ResponseEntity<String>(service.updateTourist(touristId, fare), HttpStatus.OK);
		} catch (TouristNotFoundException tn) {
			throw new TouristNotFoundException(tn.getMessage());
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteTouristById/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable("id") Integer id) {
		try {
			service.deleteTourist(id);
			return new ResponseEntity<String>("Deleted Successfully for Tourist ID:"+id, HttpStatus.OK);
		} catch (TouristNotFoundException tn) {
			throw new TouristNotFoundException(tn.getMessage());
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteTouristRecord")
	public ResponseEntity<String> deleteAllTourists() {
		try {
			service.deleteAllTourist();
			return new ResponseEntity<String>("Deleted all the tourist entries successfully", HttpStatus.OK);
		} catch (TouristNotFoundException tn) {
			throw new TouristNotFoundException(tn.getMessage());
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
