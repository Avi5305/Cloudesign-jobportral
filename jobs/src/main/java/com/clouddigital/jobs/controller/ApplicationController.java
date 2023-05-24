package com.clouddigital.jobs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clouddigital.jobs.entities.Application;
import com.clouddigital.jobs.entities.Position;
import com.clouddigital.jobs.entities.Resume;
import com.clouddigital.jobs.entities.jobSeeker;
import com.clouddigital.jobs.services.ApplicationService;
import com.clouddigital.jobs.services.JobseekerService;
import com.clouddigital.jobs.services.ResumeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService appservice;
    
    @Autowired
    private JobseekerService jservice;

    
    @Autowired
    private ResumeService rservice;

	@PostMapping("/addapplication")
	public Application addApplication(@RequestBody Application a)
	{
		System.out.print(a.toString());
		jobSeeker js = a.getJobseeker();
//		
		Position p = a.getPosition();
		Application app = new Application(a.getFname(),a.getLname(),a.getContact_no(),null,a.getEmail(),js, p);
		return appservice.addApplication(app);
//		
	}
	
	@PostMapping("/addapplicationdocs/{appid}")
	public Application addApplication(@PathVariable int appid,
			@RequestPart("resume") MultipartFile resume)
	{
		try
		{
			Resume r = new Resume(resume.getBytes());
			Resume inserted =rservice.save(r);
			Application a= appservice.updateDoc(appid , inserted);
			//System.out.print(a);
			
			return a;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		
		
		return new Application();}

	}

}
