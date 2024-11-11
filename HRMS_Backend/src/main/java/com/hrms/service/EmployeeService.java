package com.hrms.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.hrms.dto.EmployeeDto;
import com.hrms.entity.Employee;

@Service
public interface EmployeeService {

	

	
	 public EmployeeDto creatEmployee(MultipartFile profilePath, MultipartFile appointmentLetterPath,
				MultipartFile relivingLetterPath, MultipartFile experienceLetterPath,EmployeeDto employeeDto) 
						throws IOException ;
	    	
	
	public EmployeeDto createEmployee(EmployeeDto employeedto);

	public EmployeeDto getEmployee(int Id);

	List<EmployeeDto> getAllEmployee();
	
	void deletePost(int id);
	
	public EmployeeDto updateEmployee(int id, EmployeeDto employee);

	
     
}
