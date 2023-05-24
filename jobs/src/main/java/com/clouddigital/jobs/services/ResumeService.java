package com.clouddigital.jobs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouddigital.jobs.entities.Resume;
import com.clouddigital.jobs.repositories.ResumeRepository;

@Service
public class ResumeService {

	@Autowired
	private ResumeRepository rrepo;
	public Resume save(Resume r) {
		// TODO Auto-generated method stub
		return rrepo.save(r);
	}

}
