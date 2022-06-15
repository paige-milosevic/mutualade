package com.codingdojo.mutualade.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mutualade.models.OrgAid;
import com.codingdojo.mutualade.repos.OrgAidRepo;

@Service
public class OrgAidService {

	@Autowired
	OrgAidRepo orgAidRepo;
	
	// Greate Org Aid
	
	public OrgAid createOrgAid(OrgAid orgAid) throws ParseException {
		
		if(orgAid.getDateSTR() == "") {
			return orgAidRepo.save(orgAid);
		}
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateUpdated = date.parse(orgAid.getDateSTR());
		orgAid.setAidDate(dateUpdated);
		
		return orgAidRepo.save(orgAid);
		
	}
	
	// Get All Org Aid
	
	public List<OrgAid> allOrgAid() {
		return orgAidRepo.findAll();
	}
	
}
