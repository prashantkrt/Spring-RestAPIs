package com.myLearning.springRest.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.myLearning.springRest.model.Passenger;

public interface ITicketRepository extends JpaRepository<Passenger, Integer> {

}
