package com.clouddigital.jobs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouddigital.jobs.entities.jobSeeker;
import com.clouddigital.jobs.repositories.jobSeekerRepository;

@Service
public class JobseekerService
{
	@Autowired
	jobSeekerRepository jobseekerrepo;
	
	public jobSeeker regjobSeeker(jobSeeker j)
	{
		return jobseekerrepo.save(j);
	}
	
	public jobSeeker getjobSeeker(int jid)
	{
		return jobseekerrepo.findById(jid).get();
	}
}
