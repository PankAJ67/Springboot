	package com.crud.controller;

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

import com.crud.dto.UserDto;
import com.crud.service.UserService;

@RestController
@RequestMapping("/api/user")
public class Controller {

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createdUserDto = userService.createEmployee(userDto);
		return new ResponseEntity<UserDto>(createdUserDto, HttpStatus.CREATED);

	}

	@PostMapping("/genrate")
	public ResponseEntity<UserDto> generateotp(@RequestParam String email) {

		try {
			UserDto a = userService.generateOtp(email);
			return ResponseEntity.ok(a);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/get")
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<UserDto> a = userService.getAllEmployee();
		return new ResponseEntity<>(a, HttpStatus.OK);

	}

	@DeleteMapping("user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		this.userService.deleteUser(id);
		return ResponseEntity.ok("Employee Deleted Successfully");
	}

	@PutMapping("user/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
		UserDto user = userService.updateUser(id, userDto);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/validateOtp")
	public boolean validateOtp(@RequestParam String email ,@RequestParam String otp)
	{
	return  userService.isOtpValid(email, otp);

	}
	
}
