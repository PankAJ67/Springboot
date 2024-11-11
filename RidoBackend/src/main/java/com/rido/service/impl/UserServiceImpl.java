 package com.rido.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rido.dto.UserDto;
import com.rido.entity.User;
import com.rido.exception.ResourceNotFoundException;
import com.rido.repository.UserRepository;
import com.rido.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto addUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		User savedUser = this.userRepo.save(user);
		UserDto userDto2 = this.modelMapper.map(savedUser, UserDto.class);
		return userDto2;
	}

	@Override
	public UserDto getUser(Long id) {
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User"));
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

}
