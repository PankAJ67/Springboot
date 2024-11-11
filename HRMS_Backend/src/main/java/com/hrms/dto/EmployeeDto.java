package com.hrms.dto;

import java.time.LocalDate;
import java.util.List;

import com.hrms.entity.Project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {
	private int id;


	
	private String employeeId;
	private String firstName;
	private String emailAddress;
	private String lastName;
	
	private String password;

	

	private Long mobileNumber;
	private LocalDate dateOfBirth;

	private String nationality;


	private String address;

	private String city;

	private int salary;

	private String employeeType;

	private String officeLocation;

	private String designation;

	private int workingDays;

	private String department;

	private LocalDate joiningDate;

	private String profilePath;
	private String appointmentLetterPath;
	private String relivingLetterPath;
	private String experienceLetterPath;
	
    private String employeeRole;
	
	private List<Project> project;

}
