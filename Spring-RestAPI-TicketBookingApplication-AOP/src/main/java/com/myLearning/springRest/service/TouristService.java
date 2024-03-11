package com.myLearning.springRest.service;

import java.util.List;

import com.myLearning.springRest.exception.TouristNotFoundException;
import com.myLearning.springRest.model.Tourist;

public interface TouristService {

	public String regsiterTourist(Tourist tourist);

	public String regsiterAllTourist(List<Tourist> tourist);

	public Tourist fetchTourist(Integer id) throws TouristNotFoundException;

	public Tourist getTourist(Integer id);

	public List<Tourist> getAllTourist();

	public String updateTourist(Tourist tourist);

	public String updateTourist(Integer id, Double fare);
	
	public void deleteTourist(Integer id);
	
	public void deleteAllTourist();

}
