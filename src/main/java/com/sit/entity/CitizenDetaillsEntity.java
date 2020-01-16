package com.sit.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "SSN_MASTER")
public class CitizenDetaillsEntity {

	@Id
	@GeneratedValue
	@Column(name = "CITIZEN_ID")
	private Integer cid;

	@Column(name = "FIRST_NAME",length = 20)
	private String fname;

	@Column(name = "LAST_NAME",length = 20)
	private String lname;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "GENDER",length = 6)
	private String gender;

	@Column(name = "STATE", length = 2)
	private String state;
	
	@Column(name="SSN" , length = 9)
	private String ssn;
	
	@Column(name="CREATED_DATE")
	@CreationTimestamp
	private Timestamp createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private Timestamp updatedDate;
}