package com.forgotpassword.service.IMPL;

import java.util.Random;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forgotpassword.model.Users;
import com.forgotpassword.repository.UsersRepository;
import com.forgotpassword.request.RegisterRequest;
import com.forgotpassword.responses.RegisterResponse;
import com.forgotpassword.service.UserService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

	@Autowired
	private final EmailService  emailService;
	
	@Autowired
	private final UsersRepository usersRepository;
	

//
//	UserServiceImplementation(UsersRepository usersRepository, EmailService emailService) {
//        this.emailService = emailService;
//		this.usersRepository = usersRepository;
//	}
	

	@Override
	public RegisterResponse register(RegisterRequest registerRequest) {
		Users existingUser = usersRepository.findByEmail(registerRequest.getEmail());
		if (existingUser != null && existingUser.isVerified()) {
			throw new RuntimeException("User already registeres");
		}
		Users users = Users.builder()
				.userName(registerRequest.getUserName())
				.email(registerRequest.getEmail())
				.password(registerRequest.getPassword()).build();

		String otp= 	generateOTP();
		users.setOtp(otp);
		 
		      Users saveduser = usersRepository.save(users);
	
	
	SendVerificationEmail(saveduser.getEmail(),otp);
	
	

	RegisterResponse response= RegisterResponse.builder()
    		.userName(users.getUserName()) 
    		 .email(users.getEmail())
         .build();

	return response;
	}	
	
	
	
	private String generateOTP()
	{	Random random = new Random();
	 int otpValue= 100000+ random.nextInt(900000);
	return String.valueOf(otpValue);
	}
	  
	private void SendVerificationEmail(String email, String otp)
	{
		
		String subject ="email verification";
		String body = "your verification :"+otp;
		emailService.sendEmail(email, subject, body);
}


	// part 3 

	@Override
	public void verify(String email, String otp) {
	Users user=	usersRepository.findByEmail(email);
	if (user == null )	
	{
		throw new RuntimeException("user not found ");
	}
	else if(user.isVerified())
	{ 
		throw new RuntimeException("user is alrready verified  ");
	}	
		else if (otp.equals(user.getOtp()))	
		{
			
			user.setVerified(true);
			usersRepository.save(user);
		}
		else {
			throw new RuntimeException("internal server error");
			
		}	
	
	}
	
	
	
	}

