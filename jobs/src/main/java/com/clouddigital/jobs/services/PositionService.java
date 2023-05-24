package com.clouddigital.jobs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouddigital.jobs.entities.Position;
import com.clouddigital.jobs.entities.Recruiter;
import com.clouddigital.jobs.repositories.PositionRepository;

@Service
public class PositionService {

	@Autowired
	private PositionRepository pRepo;
	

	private Recruiter recruiter = new Recruiter();
	
	public List<Position> getAllPositions() {
		
		return pRepo.findAll();
	}

	public List<Position> getMyPositions(int id) {
		// TODO Auto-generated method stub
		recruiter.setRecruiter_id(id);
		return pRepo.findByRecId(recruiter);
	}

}
