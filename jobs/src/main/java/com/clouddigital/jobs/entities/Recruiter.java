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
@Table(name="recruiters")
public class Recruiter
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recruiter_id;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String contact_no;
	@Column
	private String position;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recruiter(String fname, String lname, String contact_no,String position ,User user) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.position= position;
		this.user = user;
	}

	public Recruiter(int recruiter_id, String fname, String lname, String contact_no,String position, User user) {
		super();
		this.recruiter_id = recruiter_id;
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.user = user;
		this.position = position;
	}

	public Recruiter(String fname, String lname, String contact_no, String position) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.position = position;
	}
	
	public int getRecruiter_id() {
		return recruiter_id;
	}

	public void setRecruiter_id(int staff_id) {
		this.recruiter_id = staff_id;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	
}
