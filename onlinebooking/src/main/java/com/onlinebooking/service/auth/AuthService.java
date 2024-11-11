package com.onlinebooking.service.auth;

import com.onlinebooking.dto.SignupRequest;
import com.onlinebooking.dto.UserDto;

public interface AuthService {
	
	
	UserDto createCustomer(SignupRequest signupRequest );
	
 Boolean  hasCustomerWithEmail(String email);
}
