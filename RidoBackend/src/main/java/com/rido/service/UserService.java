package com.rido.service;

import com.rido.dto.UserDto;

public interface UserService {
	UserDto addUser(UserDto userDto);

	UserDto getUser(Long id);
}
