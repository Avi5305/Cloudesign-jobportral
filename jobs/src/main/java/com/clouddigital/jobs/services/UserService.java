package com.clouddigital.jobs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouddigital.jobs.entities.Recruiter;
import com.clouddigital.jobs.entities.User;
import com.clouddigital.jobs.entities.jobSeeker;
import com.clouddigital.jobs.repositories.RecruiterRepository;
import com.clouddigital.jobs.repositories.UserRepository;
import com.clouddigital.jobs.repositories.jobSeekerRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Service
public class UserService 
{
	@Autowired
    UserRepository userrepo;
	
	@Autowired
	RecruiterRepository recuiterrepo;
	
	@Autowired
	jobSeekerRepository jobseekerrepo;
	
	public Object loginCheck(String email, String password)
	{
		User u= userrepo.loginCheck(email,password);
		System.out.println(u.toString());
		if(u != null)
		{
			
			if(u.getRole().equals("recruiter"))
			{
				Recruiter s= recuiterrepo.findByUid(u);
				return s;
			}			
			else if(u.getRole().equals("jobseeker"))
			{
				jobSeeker c= jobseekerrepo.findByUid(u);				
				return c;
			}
			
		}
		return null;
		
	}

	
	public boolean checkEmailExist(String email)
	{
		User u= userrepo.checkEmailExist(email);
		if(u != null)
			return true;
		else
			return false;
	}
	
	public List<User> getAllUser()
	{
		return userrepo.findAll();
	}
}
