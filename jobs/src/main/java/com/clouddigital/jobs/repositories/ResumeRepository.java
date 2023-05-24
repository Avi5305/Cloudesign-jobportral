package com.clouddigital.jobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clouddigital.jobs.entities.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer>{

}
