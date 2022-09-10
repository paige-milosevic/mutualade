package com.codingdojo.mutualade.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.mutualade.models.LoginUser;
import com.codingdojo.mutualade.models.OrgAid;
import com.codingdojo.mutualade.models.Organization;
import com.codingdojo.mutualade.models.User;
import com.codingdojo.mutualade.repos.OrgRepo;
import com.codingdojo.mutualade.repos.UserRepo;

@Service
public class OrgService {
	
	@Autowired
	OrgRepo orgRepo;

	@Autowired
	UserRepo userRepo;
	
	// Org Registration
	
	public Organization register(Organization newUser, BindingResult result) {
		
		Optional<User> userLookUp = userRepo.findByEmail(newUser.getOrgName());
		
		if(userLookUp.isPresent()) {
			result.rejectValue("email", "Unique", "Account with this email already exists");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "Passwords do not match");
		}

		if(result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		newUser = orgRepo.save(newUser);
		System.out.println("New user created with ID: " + newUser.getId());
		
		return newUser;
		
	}
	
	// Org Login
	
	public User login(LoginUser newLogin, BindingResult result) {
		
		Optional<User> userLookUp = userRepo.findByEmail(newLogin.getEmail());
		if (!userLookUp.isPresent()) {
			result.rejectValue("email", "NoAccount", "No account found.");
			return null;
		}
		
		User user = userLookUp.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "NoMatch", "Invalid Password!");
			
		}
		
		if (result.hasErrors()) {
			return null;
		}
		
		return user;
		
	}
	
	// Get One Org
	
	public Organization oneOrg(Long id) {
		
		Organization org = orgRepo.findById(id).orElse(null);
		System.out.println(org.getOrgName());
		
		
		return org;
	}
	
	// Get OrgAid for One Org
	
	public List<OrgAid> getOrgAid(Long id) {
		
		
		
		Organization org = orgRepo.findById(id).orElse(null);
		
		List<OrgAid> orgAid = org.getOrgAid();
		

		
		return org.getOrgAid();
	}
	
	// Get All Orgs
	
	public List<Organization> allOrgs() {
		
		List<Organization> allOrgs = orgRepo.findAll();
		
		return allOrgs;
	}
	
}
