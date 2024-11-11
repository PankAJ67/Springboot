package com.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class SpringSecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new  BCryptPasswordEncoder();
	}

//
//    @Bean
//	 public DaoAuthenticationProvider authenticationProvider()
//	 {
//		 DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		 daoAuthenticationProvider.setUserDetailsService(getDetailsService());
//		 daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//	  return daoAuthenticationProvider;
//	  
//	 
//	 }
    
    @Bean
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
     System.out.println(passwordEncoder().encode("pankaj"));
    	
    	return    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
        .formLogin(login-> login.loginPage("/login")
       		                 .loginProcessingUrl("/login")
       		                 .defaultSuccessUrl("/welcome")
       		                 .permitAll())
       		.logout(logout-> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll() ) 
       		 .build(); 
       		 
    	
    }
     
    @Bean
   public AuthenticationManager authenticationManager( AuthenticationConfiguration  configuration )throws Exception 
   {
    	return configuration.getAuthenticationManager();
   }
    
    
    
     
    
     
}
     
     
     
     
     
     
     
     
     
     
     
     
	
	
	


