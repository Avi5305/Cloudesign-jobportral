package com.clouddigital.jobs.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clouddigital.jobs.entities.User;
import com.clouddigital.jobs.entities.jobSeeker;

@Repository
public interface jobSeekerRepository extends JpaRepository<jobSeeker, Integer> {

	@Query(value= "SELECT c FROM jobSeeker c WHERE user= :uid")
	public jobSeeker findByUid(User uid);
}