package com.clouddigital.jobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clouddigital.jobs.entities.Position;
import com.clouddigital.jobs.services.PositionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PositionsController {

	@Autowired
	private PositionService pservice;
	
	@GetMapping("/positions")
	public List<Position> allposition() {
		return pservice.getAllPositions();
		
	}
	@GetMapping("/mypositions/{rid}")
	public List<Position> allMyposition(@PathVariable int rid) {
		System.out.println(rid);
		return pservice.getMyPositions(rid);
		
	}
	
}
