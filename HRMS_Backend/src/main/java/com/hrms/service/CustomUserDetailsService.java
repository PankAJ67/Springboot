package com.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrms.entity.Employee;
import com.hrms.repo.EmployeeRepo;

@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

		public UserDetails loadUserByUsername(String employeeId) throws UsernameNotFoundException {
			Employee emp = this.employeeRepo.findByemployeeId(employeeId)
					.orElseThrow(()-> new  UsernameNotFoundException("User Not Found!!"));
			return emp;
		}

}
			
			
			
	//		if (emp == null) {
//				throw new UsernameNotFoundException("User Not Found!!");
//			} else {
//				return new CustomUserDetails(user);
//			}

