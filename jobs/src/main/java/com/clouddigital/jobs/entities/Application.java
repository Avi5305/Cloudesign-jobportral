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
@Table(name="applications")
public class Application {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int appid;
	  
	  @Column
	  private String fname;
	  @Column
	  private String lname;
	  @Column
	  private String contact_no;
	  
	  @Column
	  private String email;
	  @Column
	  private String experience;
	  
	  @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "resumeid")
		private Resume resume;
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name="job_seeker_id")
	  private jobSeeker jobseeker;
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name="pid")
	  private Position position;
	public Application(String fname, String lname, String contact_no, Resume resume, String email,
			String experience) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.resume = resume;
		this.email = email;
		this.experience = experience;
	}
	public Application(String fname, String lname, String contactnumber, Resume resume, String email,
			String experience, jobSeeker jobseeker, Position position) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contactnumber;
		this.resume = resume;
		this.email = email;
		this.experience = experience;
		this.jobseeker = jobseeker;
		this.position = position;
	}
	
	public Application(String fname, String lname, String contact_no, String email, String experience,
			jobSeeker jobseeker, Position position) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.email = email;
		this.experience = experience;
		this.jobseeker = jobseeker;
		this.position = position;
	}
	public Application() {
		// TODO Auto-generated constructor stub
	}
	public int getAppId() {
		return appid;
	}
	public void setAppId(int appId) {
		this.appid = appId;
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
	public String getContactnumber() {
		return contact_no;
	}
	public void setContactnumber(String contactnumber) {
		this.contact_no = contactnumber;
	}
	
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public jobSeeker getJobseeker() {
		return jobseeker;
	}
	public void setJobseeker(jobSeeker jobseeker) {
		this.jobseeker = jobseeker;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	  
	  
	  
	}
