package com.crud.dto;

import java.time.LocalDateTime;

import com.crud.entity.User;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private int id ; 
	private String email;
	private long phoneNumber;
	private String name ;
	private String otp ;
	

	private LocalDateTime otpGeneratedTime;
	
	

}
