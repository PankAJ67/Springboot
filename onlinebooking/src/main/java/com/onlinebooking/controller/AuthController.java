package com.onlinebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebooking.dto.SignupRequest;
import com.onlinebooking.dto.UserDto;
import com.onlinebooking.service.auth.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private  AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest){
	if(authService.hasCustomerWithEmail(signupRequest.getEmail())) {
	 return  new ResponseEntity<>("customer already exist in database ",HttpStatus.NOT_ACCEPTABLE);
	}

	UserDto createdCustomerDto = authService.createCustomer(signupRequest);
	if(createdCustomerDto == null )
	 return  new ResponseEntity<>("customer not created , come again later" ,HttpStatus.BAD_REQUEST);
	
	 return  new ResponseEntity<>( createdCustomerDto ,HttpStatus.CREATED);
	}
	}

	
	

