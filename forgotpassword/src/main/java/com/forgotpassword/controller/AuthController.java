package com.forgotpassword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.forgotpassword.request.RegisterRequest;
import com.forgotpassword.responses.RegisterResponse;
import com.forgotpassword.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest  registerRequest){	
RegisterResponse registerResponse = userService.register(registerRequest);
	return new ResponseEntity<>(registerResponse, HttpStatus.CREATED);
}
	
	// day 3 to verify  
	
	@PostMapping("/verify")
	public ResponseEntity<?> verifyUser(@RequestParam String email,@RequestParam String otp){
		try {
			userService.verify(email, otp);
		return new  ResponseEntity<>("user verified successfuly ", HttpStatus.OK);
		}
catch(Exception e)
		{
	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	
}
