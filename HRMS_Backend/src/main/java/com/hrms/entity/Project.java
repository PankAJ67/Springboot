package com.hrms.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 100, nullable = false)
	private String customerName;
	@Column(length = 100, nullable = false)
	private String companyName;
	@Column(length = 100, nullable = false)
	private String emailId;
	private Long phoneNumber;
	@Column(length = 100, nullable = false)
	private String CountryName;

	@Column(length = 100, nullable = false)
	private String projectStatus;

	private String projectId;
	@Column(length = 100, nullable = false)
	private String projectTitle;
	@Column(length = 100, nullable = false)
	private String ProjectManager;
	private int teamSize;
	
	@JsonProperty("start_date")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate startDate;
	
	@JsonProperty("finish_date")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate finishDate;

	@Column(length = 100, nullable = false)
	private String Description;
	@Column(length = 150, nullable = false)
	private String technologyUsed;
	@Column(length = 200, nullable = false)
	private String skillRequired;

	private String filepath;

	@ManyToMany
	@JsonIgnore
	private List<Employee> employee;
	
	
	//  (cascade = CascadeType.ALL) jidar save  krte hai udhar cascade nahi karenge 

}
