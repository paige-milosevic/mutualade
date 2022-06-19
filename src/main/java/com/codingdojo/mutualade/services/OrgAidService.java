package com.codingdojo.mutualade.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mutualade.models.OrgAid;
import com.codingdojo.mutualade.models.Organization;
import com.codingdojo.mutualade.repos.OrgAidRepo;

@Service
public class OrgAidService {

	@Autowired
	OrgAidRepo orgAidRepo;
	
	// Create Org Aid
	
	public OrgAid createOrgAid(OrgAid orgAid) throws ParseException {
		
		if(orgAid.getDateSTR() == "") {
			return orgAidRepo.save(orgAid);
		}
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateUpdated = date.parse(orgAid.getDateSTR());
		orgAid.setAidDate(dateUpdated);
		
		return orgAidRepo.save(orgAid);
		
	}
	
	// Update One Org Aid
	
	public OrgAid updateOrgAid(OrgAid orgAid) throws ParseException {

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateUpdated = date.parse(orgAid.getDateSTR());
		orgAid.setAidDate(dateUpdated);
		
		return orgAidRepo.save(orgAid);
		
	}
	
	// Get One Org Aid
	
	public OrgAid oneOrgAid(Long id) {
		
		OrgAid orgAid = orgAidRepo.findById(id).orElse(null);
		
		if(orgAid.getDateSTR() == null) {
			System.out.println(orgAid.getDateSTR());
			return orgAidRepo.findById(id).orElse(null);
		}
		
		Date date = orgAid.getAidDate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		orgAid.setDateSTR(strDate);
		System.out.println(orgAid.getDateSTR());
		System.out.println(orgAid.getAidDate());
		return orgAidRepo.findById(id).orElse(null);
		
	}
	
	// Get Org Aid User ID
	
	public Organization getOrgId(Long id) {
		
		OrgAid orgAid = orgAidRepo.findById(id).orElse(null);
		Organization org = orgAid.getOrg();
		return org;
		
	}
	
	// Get All Org Aid
	
	public List<OrgAid> allOrgAid() {
		return orgAidRepo.findAll();
	}
	
	// Delete Org Aid
	
	public void deleteAid(Long id) {
		orgAidRepo.deleteById(id);
	}
	
}
