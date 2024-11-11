package com.studentapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new  BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService getDetailsService()
	{
		return new CustomUserDetailsService();
		
	}
    @Bean
	 public DaoAuthenticationProvider authenticationProvider()
	 {
		 DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		 daoAuthenticationProvider.setUserDetailsService(getDetailsService());
		 daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	  return daoAuthenticationProvider;
	  
	 
	 }
    
    @Bean
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(requests -> requests.requestMatchers("/").permitAll().anyRequest().authenticated()).formLogin(withDefaults());
    
    	
    	return http.build();
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
	
	
}
