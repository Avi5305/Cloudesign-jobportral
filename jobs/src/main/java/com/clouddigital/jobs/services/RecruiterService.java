package com.clouddigital.jobs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouddigital.jobs.entities.Recruiter;
import com.clouddigital.jobs.repositories.RecruiterRepository;


@Service
public class RecruiterService {
	@Autowired
	RecruiterRepository recuiterrepo;
	
	public Recruiter regRecruit(Recruiter r)
	{
		return recuiterrepo.save(r);
	}
	
	
}
