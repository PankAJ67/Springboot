package com.hrms.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.dto.EmployeeDto;
import com.hrms.entity.AuthenticationRequest;
import com.hrms.entity.AuthenticationResponse;
import com.hrms.entity.Employee;
import com.hrms.helper.JwtUtil;
import com.hrms.service.CustomUserDetailsService;
import com.hrms.service.EmployeeService;

@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

	
	

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getEmployeeId(), authenticationRequest.getPassword()));

			final Employee userDetails = (Employee) userDetailsService
					.loadUserByUsername(authenticationRequest.getEmployeeId());
			final String jwt = jwtUtil.generateToken(userDetails);
System.out.println("authentication rest controller");

			return new AuthenticationResponse(jwt);
			
		} catch (AuthenticationException e) {
			System.out.println("authentication rest controller2");
			throw new Exception("Incorrect employeeId or password", e);
		}

	}
	
	
	
	@GetMapping("/current-employee")
public ResponseEntity<?> getCurrentUser(Employee employee) {
		 List<EmployeeDto> a = employeeService.getAllEmployee();
	
			return new ResponseEntity<>(a, HttpStatus.OK);
}
}