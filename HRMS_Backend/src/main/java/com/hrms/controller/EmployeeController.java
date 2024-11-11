package com.hrms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hrms.dto.EmployeeDto;
import com.hrms.service.EmployeeService;

@RestController
@RequestMapping("/ok")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee/addd")
	public ResponseEntity<EmployeeDto> createUser(@RequestParam("profile") MultipartFile profilePath,
			@RequestParam("appointment") MultipartFile appointmentLetterPath,
			@RequestParam("reliving") MultipartFile relivingLetterPath,
			@RequestParam("experience") MultipartFile experienceLetterPath, @RequestParam("json") String employeeDto)
			throws IOException {

		ObjectMapper object = new ObjectMapper();
		object.registerModule(new JavaTimeModule());
		object.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		EmployeeDto employee = object.readValue(employeeDto, EmployeeDto.class);

		EmployeeDto createdEmpDto = this.employeeService.creatEmployee(profilePath, appointmentLetterPath,
				relivingLetterPath, experienceLetterPath, employee);

		return new ResponseEntity<>(createdEmpDto, HttpStatus.CREATED);
	}

	@PostMapping("/employee/add")
	public ResponseEntity<EmployeeDto> createUser(@RequestBody EmployeeDto employeeDTO) {
		EmployeeDto createdUserDto = this.employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<EmployeeDto>(createdUserDto, HttpStatus.CREATED);
	}

// update it with UserDto
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> getUser(@PathVariable("id") int Id) {
		EmployeeDto userDto = this.employeeService.getEmployee(Id);
		System.out.println("one");
		return new ResponseEntity<EmployeeDto>(userDto, HttpStatus.OK);

	}

	@GetMapping("/employee/get")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
		System.out.println("252o5............");

		List<EmployeeDto> users = employeeService.getAllEmployee();
		return new ResponseEntity<>(users, HttpStatus.OK);

	}	

	@DeleteMapping("employee/{id}")
	public ResponseEntity<EmployeeDto> deletePost(@PathVariable(name = "id") int id) {
		employeeService.deletePost(id);
		EmployeeDto apiResponse = new EmployeeDto();
		return new ResponseEntity<EmployeeDto>(apiResponse, HttpStatus.OK);
	}

	@PutMapping("employee/{id}")
	public ResponseEntity<EmployeeDto> updatePost(@PathVariable int id, @RequestBody EmployeeDto postDto) {

		// convert DTO to Entity

		EmployeeDto post = employeeService.updateEmployee(id, postDto);

		return ResponseEntity.ok().body(post);
	}

}
