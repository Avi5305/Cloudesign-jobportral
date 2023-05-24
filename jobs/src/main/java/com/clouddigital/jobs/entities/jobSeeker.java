package com.clouddigital.jobs.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="job_seekers")
public class jobSeeker
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int job_seeker_id;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String contact_no;
	
	//@JsonIgnoreProperties("user_id")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	public jobSeeker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public jobSeeker(String fname, String lname, String contact_no, User user) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.user = user;
	}

	public jobSeeker(int citizen_id, String fname, String lname, String contact_no, User user) {
		super();
		this.job_seeker_id = citizen_id;
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.user = user;
	}

	public jobSeeker(int citizen_id, String fname, String lname, String contact_no) {
		super();
		this.job_seeker_id = citizen_id;
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
	}



	public jobSeeker(int job_seeker_id) {
		super();
		this.job_seeker_id = job_seeker_id;
	}

	public int getJob_seeker_id() {
		return job_seeker_id;
	}

	public void setJob_seeker_id(int job_seeker_id) {
		this.job_seeker_id = job_seeker_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
