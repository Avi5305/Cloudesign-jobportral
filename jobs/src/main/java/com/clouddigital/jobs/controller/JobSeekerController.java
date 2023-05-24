package com.clouddigital.jobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clouddigital.jobs.entities.JobSeekerRegister;
import com.clouddigital.jobs.entities.User;
import com.clouddigital.jobs.entities.jobSeeker;
import com.clouddigital.jobs.services.JobseekerService;
import com.clouddigital.jobs.services.RecruiterService;
import com.clouddigital.jobs.services.UserService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class JobSeekerController
{
	@Autowired
	UserService uservice;
	
	@Autowired
	JobseekerService jservice;
	
	@Autowired
	RecruiterService rservice;
	
	@Autowired
	JavaMailSender sender;
	
	@PostMapping("/jobSeekerreg")
	public jobSeeker regJobSeeker(@RequestBody JobSeekerRegister nc)
	{
		User u= new User(nc.getEmail(), nc.getPassword(), "jobseeker");
		jobSeeker j= new jobSeeker(nc.getFname(), nc.getLname(), nc.getContact_no(), u);
		jobSeeker newjobSeeker= jservice.regjobSeeker(j);
		if(newjobSeeker != null)
		{
			SimpleMailMessage mail= new SimpleMailMessage();
			mail.setFrom("KONIJOBDETAKAJOB@gmail.com");
			mail.setTo(newjobSeeker.getUser().getEmail());
			mail.setSubject("A-Z_JOBS Registration");
			mail.setText("Your have successfully registered A-Z_JOBS.");
			sender.send(mail);
		}
		return newjobSeeker;
	}
	

}
