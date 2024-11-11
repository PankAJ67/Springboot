package com.studentapp.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService getDetailsService() {
		return new CustomUserDetailsService();

	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;

	}

//	@Bean
//	SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable())
//				.authorizeHttpRequests(
//						requests -> requests.requestMatchers("/").permitAll().anyRequest().authenticated())
//				.formLogin(login -> login.loginPage("/signin")
//						.loginProcessingUrl("/login")// isme sign mapping ka hai login page hai login page action wla hai usko kuch bhi naam de 
//						.defaultSuccessUrl("/about") //  uske baad apne to direct relogin krna hai jo pasge uska mapping 
//						.failureUrl("/invalid") // agar password galat ho to ye qwla page direct hoga 
//						.permitAll());
// 
//		return http.build();
	
	
	// isme agar same page me hi detail show krna hai to 
//		@Bean
//		SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
//			http.csrf(csrf -> csrf.disable())
//					.authorizeHttpRequests(
//							requests -> requests.requestMatchers("/").permitAll().anyRequest().authenticated())
//					.formLogin(login -> login.loginPage("/signin")
//							.loginProcessingUrl("/login")// isme sign mapping ka hai login page hai login page action wla hai usko kuch bhi naam de 
//							.defaultSuccessUrl("/about") //  uske baad apne to direct relogin krna hai jo pasge uska mapping 
//							
//							.permitAll());
//	 
//			return http.build();
	
	
	
	//isme logout ke baad kuch page me leke jana ho to 
	@Bean
	SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						requests -> requests.requestMatchers("/login").permitAll().anyRequest().authenticated())
				.formLogin(login -> {
					try {
						login.loginPage("/signin")
								.loginProcessingUrl("/login")
								// isme sign mapping ka hai login page hai login page action wla hai usko kuch bhi naam de 
								.defaultSuccessUrl("/about").permitAll() 
								//  uske baad apne to direct relogin krna hai jo pasge uska mapping 
							.and().logout().logoutSuccessUrl("/userlogout")
								.permitAll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
 
		return http.build();
	}

}
