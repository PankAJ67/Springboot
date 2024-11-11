package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.entities.Student;
import com.studentapp.repository.StudentRepository;






@SpringBootApplication
public class OnetooneApplication {
	
	

@Autowired
private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnetooneApplication.class, args);
System.out.println("ok created");
	
	
Student student= new Student();
student.setStudentName("PANKAJ");
student.setAbout("ok");
student.setStudentId(101);


	studentRepository.save(student);

	}

}
