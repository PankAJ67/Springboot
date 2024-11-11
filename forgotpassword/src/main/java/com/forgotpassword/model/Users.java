package com.forgotpassword.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;


@Builder
@Entity
@Table(name= "usera")
public class Users {

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	 private String userName;
	 private String email;
	 private String password;
	 private String Otp;
	 
	 public Users(int userId, String userName, String email, String password, String otp, boolean verified) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		Otp = otp;
		this.verified = verified;
	}
	private boolean verified;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getOtp() {
		return Otp;
	}
	public void setOtp(String otp) {
		Otp = otp;
	}
	 
	
}
