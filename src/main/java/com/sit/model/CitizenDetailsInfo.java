package com.sit.model;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class CitizenDetailsInfo {
	
	private Integer cid;
	
	private String fname;
	
	private String lname;
	
	private Date dob;
	
	private String gender;
	
	private String state;
		
	
}