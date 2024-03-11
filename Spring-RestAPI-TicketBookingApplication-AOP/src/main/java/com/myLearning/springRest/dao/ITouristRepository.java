package com.myLearning.springRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myLearning.springRest.model.Tourist;

public interface ITouristRepository extends JpaRepository<Tourist, Integer> {

}
