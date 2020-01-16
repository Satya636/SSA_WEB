package com.sit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sit.entity.CitizenDetaillsEntity;

public interface CitizenInfoRepo  extends JpaRepository<CitizenDetaillsEntity, Integer>{

	
	public CitizenDetaillsEntity findByssn(String ssn);
	
}
