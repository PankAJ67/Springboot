package com.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.dto.UserDto;

@Service
public interface UserService {

	public UserDto createEmployee(UserDto userdto);

	List<UserDto> getAllEmployee();

	void deleteUser(int id);

	public UserDto updateUser(int id, UserDto userDto);
	
	UserDto generateOtp(String email);
	
	boolean isOtpValid(String email, String otp);

	void invalidateExpiredOtps();
	

	 

}
