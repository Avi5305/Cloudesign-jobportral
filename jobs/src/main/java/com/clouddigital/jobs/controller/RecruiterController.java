package com.clouddigital.jobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clouddigital.jobs.entities.Recruiter;
import com.clouddigital.jobs.entities.RecruiterRegister;
import com.clouddigital.jobs.entities.User;
import com.clouddigital.jobs.services.JobseekerService;
import com.clouddigital.jobs.services.RecruiterService;
import com.clouddigital.jobs.services.UserService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RecruiterController
{
	@Autowired
	UserService uservice;
	
	@Autowired
	JobseekerService jservice;
	
	@Autowired
	RecruiterService rservice;
	
	@PostMapping("/recruiterreg")
	public Recruiter regRecruit(@RequestBody RecruiterRegister ns)
	{
		User u= new User(ns.getEmail(), ns.getPassword(), "recruiter");
		Recruiter s= new Recruiter(ns.getFname(), ns.getLname(), ns.getContact_no(),ns.getPosition(), u);
		return rservice.regRecruit(s);
	}

}
