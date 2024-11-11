package com.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentapp.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

	
	public Employee findByEmail(String email);
	
}
