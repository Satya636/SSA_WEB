package com.sit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sit.entity.StatesListEntity;

public interface StatesListRepo extends JpaRepository<StatesListEntity, Integer> {
	
	
	@Query("select stateCode from StatesListEntity where stateName=:stateName")
	public String fetchStatecodeByName(String stateName);

}
