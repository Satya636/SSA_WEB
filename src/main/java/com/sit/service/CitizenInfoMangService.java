package com.sit.service;

import java.util.List;

import com.sit.entity.CitizenDetaillsEntity;
import com.sit.model.CitizenDetailsInfo;

public interface CitizenInfoMangService {

	public List<String> getCitiesList();
	
	public CitizenDetaillsEntity saveCitizenInfo(CitizenDetailsInfo cInfo);
	
	public String getCityCodeByCityName(String stateName);
	
    public CitizenDetaillsEntity getDetailsBySSN(Integer ssn);
}
