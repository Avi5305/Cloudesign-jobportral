package com.clouddigital.jobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clouddigital.jobs.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE email= :email AND password= :password")
	public User loginCheck(String email, String password);
	
	@Query("SELECT u FROM User u WHERE email= :email")
	public User checkEmailExist(String email);
}
