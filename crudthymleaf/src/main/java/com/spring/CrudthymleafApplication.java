package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.repo.StudentRepo;

@SpringBootApplication
public class CrudthymleafApplication implements CommandLineRunner {

	@Autowired
	private StudentRepo repo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CrudthymleafApplication.class, args);
	}

}
