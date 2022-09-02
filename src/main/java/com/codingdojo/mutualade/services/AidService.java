package com.codingdojo.mutualade.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mutualade.models.AidRequest;
import com.codingdojo.mutualade.repos.AidRepo;

@Service
public class AidService {

	@Autowired
	AidRepo aidRepo;
	
	// Get All Aid Requests
	public List<AidRequest> allAidRequests() {
		return aidRepo.findAll();
	}
	
	// Create Aid Request
	public AidRequest createAidReq(AidRequest aidReq) throws ParseException {
		
		System.out.println(aidReq.getDateSTR());
		
		if(aidReq.getDateSTR() == "") {	
			return aidRepo.save(aidReq);
		}
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateUpdated = date.parse(aidReq.getDateSTR());
		aidReq.setAidDate(dateUpdated);
		
		
		return aidRepo.save(aidReq);
	}
	
	// Update Aid Request
	public AidRequest updateAidReq(AidRequest aidReq) throws ParseException {
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateUpdated = date.parse(aidReq.getDateSTR());
		aidReq.setAidDate(dateUpdated);
		
		return aidRepo.save(aidReq);
	}
	
	// Get One Aid Request
	public AidRequest oneAidReq(Long id) {
	
		
		AidRequest aidReq = aidRepo.findById(id).orElse(null);
		
		if(aidReq.getDateSTR() != null) {
			System.out.println(aidReq.getDateSTR());
			return aidRepo.findById(id).orElse(null);
		}
		
		Date date = aidReq.getAidDate();
		DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
		String strDate = dateFormat.format(date);
		
		aidReq.setDateSTR(strDate);
		System.out.println(aidReq.getDateSTR());
		System.out.println(aidReq.getAidDate());
		return aidRepo.findById(id).orElse(null);
	}
	
	// Delete Aid Request
	public void deleteAid(Long id) {
		aidRepo.deleteById(id);
	}
	
	
}
