package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;
	
	
	@Override
	public void registerUser(User user) {
		repo.save(user);
		 
	}


	@Override
	public void registeUser(User user) {
		// TODO Auto-generated method stub
		
	}


}
