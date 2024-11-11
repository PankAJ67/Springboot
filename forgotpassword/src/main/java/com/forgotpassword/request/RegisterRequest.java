package com.forgotpassword.request;

import com.forgotpassword.responses.RegisterResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterRequest {
	
	 private String userName;
	 private String email;
	 private String password;

}
