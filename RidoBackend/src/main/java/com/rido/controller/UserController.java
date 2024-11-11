package com.rido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rido.dto.UserDto;
import com.rido.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
		UserDto addUser = this.userService.addUser(userDto);
		return new ResponseEntity<>(addUser, HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
		UserDto user = this.userService.getUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
