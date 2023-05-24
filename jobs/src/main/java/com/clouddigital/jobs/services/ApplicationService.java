package com.clouddigital.jobs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouddigital.jobs.entities.Application;
import com.clouddigital.jobs.entities.Resume;
import com.clouddigital.jobs.repositories.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepository apprepo;
	
	public Application addApplication(Application app) {

		
		/*Document doc;
		Citizen c;
		Application app;
		try
		{
			doc= new Document(file1.getBytes(), file2.getBytes(),file3.getBytes());
			c= new Citizen(a.getCitizen().getFname(), a.getCitizen().getLname(), a.getCitizen().getContact_no(),
					a.getCitizen().getUser());
			
			app= new Application(a.getAadhar(),a.getDOB(),a.getBlood_group(),a.getGender(),a.getIdentification_mark(),
					a.getPresent_address(),a.getPermanent_address(),a.getApplication_type(),c,doc);
			
			return apprepo.save(app);
		}
		catch (IOException e)
		{
			return null;
		} */
		return apprepo.save(app);
	}

	public Application updateDoc(int aid, Resume resume) {
		// TODO Auto-generated method stub
		int i = apprepo.updateDoc(aid,resume);
		System.out.print(i);
		if(i==1)
			return getAppById(aid);
		else
			return null;	}

	private Application getAppById(int aid) {
		// TODO Auto-generated method stub
		return apprepo.getAppByAppId(aid);
	}

}
