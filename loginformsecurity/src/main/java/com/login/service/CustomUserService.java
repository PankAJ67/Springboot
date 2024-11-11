package com.login.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.model.User;
import com.login.repository.UserRepository;


@Service

public class CustomUserService  implements UserDetailsService{

	
   @Autowired
	private UserRepository userRepository;
	
   
   @Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws  UsernameNotFoundException{
	
	   
  User user = userRepository.findByUsernameOrEmail(usernameOrEmail ,usernameOrEmail).orElseThrow(  () -> new UsernameNotFoundException("User Not Found with -> username or email: " + usernameOrEmail));

	   
//	User user = userRepository.findByUsernameOrEmail(usernameOrEmail ,usernameOrEmail);
//			orElseThrow(()-> new UsernameNotFoundException(  " email not found in data base "));
////	 
//	
	
	  Set<GrantedAuthority> authorities= user.getRole().stream()
			.map(role-> new SimpleGrantedAuthority(role.getName()) )
			.collect(Collectors.toSet());
			
			return new org.springframework.security.core.userdetails.User(usernameOrEmail , user.getPassword(),authorities) ;
	   
	   
	   
   }


   
	
}
