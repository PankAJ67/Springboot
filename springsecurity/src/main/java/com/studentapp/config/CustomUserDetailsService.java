package com.studentapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.studentapp.entity.Employee;
import com.studentapp.repository.EmpRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private EmpRepo empRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee emp = this.empRepo.findByEmail(email);
		System.out.println(emp);
		if (emp == null) {
			throw new UsernameNotFoundException("user not found ");
		} else {
			return new CustomUser(emp);
		}

	}

}
