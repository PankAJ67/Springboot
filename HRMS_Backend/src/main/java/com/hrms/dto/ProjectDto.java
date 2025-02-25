package com.hrms.dto;

import java.time.LocalDate;
import java.util.List;

import com.hrms.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProjectDto {

	private long id;

	private String customerName;
	private String companyName;
	private String emailId;
	private Long phoneNumber;
	private String CountryName;
	private String projectStatus;

	private String projectId;
	private String projectTitle;
	private String ProjectManager;
	private int teamSize;
	private LocalDate startDate;
	private LocalDate finishDate;

	private String Description;
	private String technologyUsed;
	private String skillRequired;
	private String filepath;

	private List<Employee> employee;


	}


