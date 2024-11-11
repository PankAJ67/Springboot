package com.onlinebooking.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebooking.dto.SignupRequest;
import com.onlinebooking.dto.UserDto;
import com.onlinebooking.entity.User;
import com.onlinebooking.enums.UserRole;
import com.onlinebooking.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl  implements  AuthService {

	@Autowired
	private UserRepository  userRepository ;

	@Override
	public UserDto createCustomer(SignupRequest signupRequest) {
		
		User user = new User();
		user.setName(signupRequest.getName());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(signupRequest.getPassword());
		user.setUserRole(UserRole.CUSTOMER);
		  User createdUser= userRepository.save(user);
		  UserDto userDto = new UserDto();
		  userDto.setId(createdUser.getId());
		  userDto.setEmail(createdUser.getEmail());
		  return userDto ;
	}

	@Override
	public Boolean hasCustomerWithEmail(String email) {
 
		return userRepository.findFirstByEmail(email).isPresent(); 
	}

}
