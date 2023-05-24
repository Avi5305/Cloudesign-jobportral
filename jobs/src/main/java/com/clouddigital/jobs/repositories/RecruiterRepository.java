package com.clouddigital.jobs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clouddigital.jobs.entities.Recruiter;
import com.clouddigital.jobs.entities.User;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter,Integer> {
	@Query(value= "SELECT c FROM Recruiter c WHERE user= :uid")
	public Recruiter findByUid(User uid);
}
