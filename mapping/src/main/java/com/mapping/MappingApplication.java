package com.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mapping.repository.EmpRepo;
import com.mapping.repository.MobileRepo;

@SpringBootApplication
public class MappingApplication {

	
	@Autowired
	private EmpRepo empRepo;
	
	
	@Autowired
	private MobileRepo mobileRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	
	
	}

}
