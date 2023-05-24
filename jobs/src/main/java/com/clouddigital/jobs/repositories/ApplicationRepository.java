package com.clouddigital.jobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clouddigital.jobs.entities.Application;
import com.clouddigital.jobs.entities.Resume;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>{


	@Modifying
	@Query("update Application set resume = :resume where appid= :aid")
	public int updateDoc(int aid, Resume resume);
	

	@Query("select a from Application a where appid= :aid")
	public Application getAppByAppId(int aid);

}
