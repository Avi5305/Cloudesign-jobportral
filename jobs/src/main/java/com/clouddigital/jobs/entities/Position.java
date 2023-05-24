package com.clouddigital.jobs.entities;

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
@Table(name="positions")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@Column
	private String name;

	@Column
	private String company;
	@Column
	private String salary;

	@Column
	private String experience;
	@Column
	private String location;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="recruiter_id")
	private Recruiter recruiter;

	public Position(int pid, String name, String company,String experience, String salary, String location, Recruiter recruiter) {
		super();
		this.pid = pid;
		this.name = name;
		this.company = company;
		this.salary = salary;
		this.experience=experience;
		this.location = location;
		this.recruiter = recruiter;
	}

	public Position(String name, String company, String salary,String experience, String location, Recruiter recruiter) {
		super();
		this.name = name;
		this.company = company;
		this.salary = salary;
		this.experience=experience;
		this.location = location;
		this.recruiter = recruiter;
	}
	

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public int getPid() {
		return pid;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	
	
	
}
