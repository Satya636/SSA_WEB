package com.sit.service;

import java.util.List;

import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sit.entity.CitizenDetaillsEntity;
import com.sit.entity.StatesListEntity;
import com.sit.model.CitizenDetailsInfo;
import com.sit.repo.CitizenInfoRepo;
import com.sit.repo.StatesListRepo;

@Service
public class CitizenInfoMangServiceImpl implements CitizenInfoMangService {

	@Autowired
	private StatesListRepo citiesRepo;

	@Autowired
	private CitizenInfoRepo ctznRepo;

	@Override
	public List<String> getCitiesList() {
		List<StatesListEntity> citiesEntity = citiesRepo.findAll();
		List<String> statesList = citiesEntity.stream().map(StatesListEntity::getStateName)
				.collect(Collectors.toList());
		return statesList;
	}

	@Override
	public CitizenDetaillsEntity saveCitizenInfo(CitizenDetailsInfo cInfo) {
		String statecode = null;
		if (cInfo != null) {
			String stateName = cInfo.getState();
			statecode = getCityCodeByCityName(stateName);
		}
		CitizenDetaillsEntity cEntity = new CitizenDetaillsEntity();
		BeanUtils.copyProperties(cInfo, cEntity);
		cEntity.setSsn(randomInt(9));
		cEntity.setState(statecode);
		CitizenDetaillsEntity savedEntity = ctznRepo.save(cEntity);
		String ssn = String.valueOf(savedEntity.getSsn());
		if (ssn != null) {
			ssn = ssn.substring(0, 3) + "-" + ssn.substring(3, 5) + "-"
					+ ssn.substring(5, 9);
		}
		savedEntity.setSsn(ssn);
		return savedEntity;
	}

	public static String randomInt(int digits) {
		int minimum = (int) Math.pow(10, digits - 1);
		int maximum = (int) Math.pow(10, digits) - 1;
		Random random = new Random();
		return String.valueOf(minimum + random.nextInt((maximum - minimum) + 1));
	}

	@Override
	public String getCityCodeByCityName(String stateName) {
		String stateCode = citiesRepo.fetchStatecodeByName(stateName);
		return stateCode;
	}
	
	
	@Override
	public CitizenDetaillsEntity getDetailsBySSN(Integer ssn) {
		CitizenDetaillsEntity ctznDetails = ctznRepo.findByssn(String.valueOf(ssn));
		return ctznDetails;
	}

}
