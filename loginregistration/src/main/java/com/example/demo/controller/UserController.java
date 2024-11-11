package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/registration")
	public String getRegPage(@ModelAttribute("user") User user)
	{
		return "register";
		}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") User user, Model model)
	{ userRepository.save(user);
	model.addAttribute("message","submitted successfully");
		return "register";
		}
	
	

}
