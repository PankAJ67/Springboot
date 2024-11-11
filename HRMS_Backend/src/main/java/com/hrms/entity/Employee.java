package com.hrms.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Employee implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	private String employeeId;
	private String firstName;
	private String emailAddress;
	private String lastName;
	
	private String password;

	

	private Long mobileNumber;
	private LocalDate dateOfBirth;

	private String nationality;


	private String address;

	private String city;

	private int salary;

	private String employeeType;

	private String officeLocation;

	private String designation;

	private int workingDays;

	private String department;

	private LocalDate joiningDate;

	private String profilePath;
	private String appointmentLetterPath;
	private String relivingLetterPath;
	private String experienceLetterPath;
	
    private String employeeRole;
	

	@ManyToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Project> project;

 
	
	@ManyToOne
	@JsonIgnore
	private Branch branch;
	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(this.employeeType));
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.employeeId;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public String getPassword() {
		return this.password;
	}

	
	

}