package com.clouddigital.jobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clouddigital.jobs.entities.Position;
import com.clouddigital.jobs.entities.Recruiter;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

	@Query("SELECT p FROM Position p WHERE recruiter= :id")
	public List<Position> findByRecId(Recruiter id);

}
