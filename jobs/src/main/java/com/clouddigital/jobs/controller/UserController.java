package com.clouddigital.jobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clouddigital.jobs.entities.User;
import com.clouddigital.jobs.services.JobseekerService;
import com.clouddigital.jobs.services.RecruiterService;
import com.clouddigital.jobs.services.UserService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	@Autowired
	UserService uservice;
	
	@Autowired
	JobseekerService jservice;
	
	@Autowired
	RecruiterService rservice;
	
	@PostMapping("/logincheck")
	public Object findUser(@RequestBody User u)
	{
		String email= u.getEmail();
		String password= u.getPassword();
		return uservice.loginCheck(email,password);
	}
	
	@GetMapping("/emailexist")
	public boolean checkEmailExist(@RequestParam String email)
	{
		System.out.print(email);
		return uservice.checkEmailExist(email);
	}

	@GetMapping("/getalluser")
	public List<User> findAllUsers()
	{
		return uservice.getAllUser();
	}
}
