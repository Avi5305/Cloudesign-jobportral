package com.clouddigital.jobs.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resumeid;
	@Column
	private byte[] resume;
	public Resume(int resumeid, byte[] resume) {
		super();
		this.resumeid = resumeid;
		this.resume = resume;
	}
	
	
	public Resume(byte[] resume) {
		super();
		this.resume = resume;
	}
	
	

	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getResumeid() {
		return resumeid;
	}
	public void setResumeid(int resumeid) {
		this.resumeid = resumeid;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	
	
}
