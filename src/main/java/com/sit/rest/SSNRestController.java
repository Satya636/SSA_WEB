package com.sit.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sit.entity.CitizenDetaillsEntity;
import com.sit.service.CitizenInfoMangService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "SSA_WEB", description = "This Rest App Is  For Accesing Services Of Federal Govt. USA")
@RestController
public class SSNRestController {

	@Autowired
	private CitizenInfoMangService citizenService;

	@ApiOperation(value = "Verify Your SSN No")
	@GetMapping(value = "/verifySSN/{ssn}", produces = "application/json")
	public ResponseEntity<String> getStateCodeBySSN(
			@ApiParam(name = "SSN No", value = "Enter SSN No") @PathVariable("ssn") Integer ssn) {
		if (ssn != null & ssn > 0) {
			CitizenDetaillsEntity ctznDetails = citizenService.getDetailsBySSN(ssn);
			if (ctznDetails != null) {
				return new ResponseEntity<>(ctznDetails.getState(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Invalid SSN No", HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<>("Please Provide A SSN No", HttpStatus.BAD_REQUEST);
	}
}
