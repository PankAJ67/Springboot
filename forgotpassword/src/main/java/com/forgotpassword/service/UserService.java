package com.forgotpassword.service;

import org.springframework.stereotype.Service;

import com.forgotpassword.request.RegisterRequest;
import com.forgotpassword.responses.RegisterResponse;

@Service
public interface UserService {

	RegisterResponse register(RegisterRequest registerRequest);

	
// part 3 
	void verify (String email, String otp);
	
	
	
}
