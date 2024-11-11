package com.hrms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hrms.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;

	@Bean
	UserDetailsService getUserDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	DaoAuthenticationProvider dao() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(getUserDetailsService());
		dao.setPasswordEncoder(passwordEncoder());
		return dao;
	}

//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
//				.authorizeHttpRequests(request -> request.requestMatchers("/auth/**").permitAll()
//						.requestMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated())
//				.exceptionHandling(exception -> exception.authenticationEntryPoint(entryPoint))
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//		return http.build();
//	}

	
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    return http.csrf().disable()
//	            .authorizeRequests(authorize ->
//	                authorize
//	                .requestMatchers("/auth/**").permitAll()
//	      
//					.requestMatchers(HttpMethod.OPTIONS).permitAll()						
//	                    .anyRequest().authenticated()
//	            )
//				.httpBasic()
//				.and()
//	            .build();
//	}
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf(csrf -> csrf.disable())
	            .cors(cors -> cors.disable())
	            .authorizeHttpRequests(authorize -> authorize
	                .requestMatchers("/auth/**").permitAll()
	                .requestMatchers(HttpMethod.OPTIONS).permitAll()
	                .anyRequest().authenticated()
	            )
	            .httpBasic().and()
	            .exceptionHandling(exceptionHandling -> 
	                exceptionHandling.authenticationEntryPoint(entryPoint)
	            )
	            .sessionManagement(sessionManagement -> 
	                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            )
	            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	        System.out.println("my security config");
	        return http.build();
	    }
		    
	
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
}

