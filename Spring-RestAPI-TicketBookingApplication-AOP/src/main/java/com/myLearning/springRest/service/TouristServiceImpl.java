package com.myLearning.springRest.service;

import java.util.List;
//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myLearning.springRest.dao.ITouristRepository;
import com.myLearning.springRest.exception.TouristNotFoundException;
import com.myLearning.springRest.model.Tourist;

@Service
public class TouristServiceImpl implements TouristService {

	@Autowired
	private ITouristRepository repo;

	@Override
	public String regsiterTourist(Tourist tourist) {
		Tourist t = repo.save(tourist);
		return "Tourist added successfully " + t.getTouristID();
	}

	@Override
	public String regsiterAllTourist(List<Tourist> tourist) {
		Iterable<Tourist> t = repo.saveAll(tourist);
		return "All Tourist added successfully " + t.toString();
	}

	@Override
	public Tourist getTourist(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public Tourist fetchTourist(Integer id) throws TouristNotFoundException {

//		Optional<Tourist> optional = repo.findById(id);
//		if (optional.isPresent()) {
//			return optional.get();
//		} else {
//			throw new Exception("Tourish not present");
//		}
		return repo.findById(id).orElseThrow(() -> new TouristNotFoundException("Tourish not present"));
	}

	@Override
	public List<Tourist> getAllTourist() {
		return repo.findAll();
	}

	@Override
	public String updateTourist(Tourist tourist) {
		// if data is there it will update
		// else throw exception
		Integer id = tourist.getTouristID();
		if (repo.findById(id).isPresent()) {
			repo.save(tourist);
			return "Tourist with id " + id + " updated";
		} else {
			throw new TouristNotFoundException("Tourist not present for update: Invalid tourist details " + id);
		}
	}

	@Override
	public String updateTourist(Integer id, Double fare) {
		Tourist tourist = repo.findById(id).get();
		if (tourist != null) {
			tourist.setTicketFare(fare);
			repo.save(tourist);
			return "Tourist with id " + id + " updated";
		} else {
			throw new TouristNotFoundException("Tourist not present for update: Invalid tourist details " + id);
		}
	}

	@Override
	public void deleteTourist(Integer id) {
		if (repo.findById(id).isPresent())
			repo.delete(repo.findById(id).get());
		else {
			throw new TouristNotFoundException("Tourist not present for deletion: Invalid tourist details " + id);
		}
	}

	@Override
	public void deleteAllTourist() {
		repo.deleteAll();		
	}
}
