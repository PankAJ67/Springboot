package com.crud.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ; 
	 @Column(unique=true)
	private String email;
	private long phoneNumber;
	private String name ;
	private String otp ;

	private LocalDateTime otpGeneratedTime;
	
	
	

}
