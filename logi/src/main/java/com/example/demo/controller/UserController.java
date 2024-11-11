package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/registerUser")
	public String register(Model model) {
		User user= new User();
		model.addAttribute( "user" ,user);
		return "register";
	}
	
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User user) {
		service.registerUser(user);
		System.out.println(user);
	
		service.registerUser(user);
		return"home"; // any page 
	}

}
