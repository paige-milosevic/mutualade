package com.codingdojo.mutualade.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.mutualade.models.LoginUser;
import com.codingdojo.mutualade.models.Member;
import com.codingdojo.mutualade.models.User;
import com.codingdojo.mutualade.repos.MemberRepo;
import com.codingdojo.mutualade.repos.UserRepo;

@Service
public class MemberService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired 
	MemberRepo memberRepo;
	
	// Member Registration
	
	public Member register(Member newMember, BindingResult result) {
		
		Optional<User> memberLookUp = userRepo.findByEmail(newMember.getEmail());
		
		if(memberLookUp.isPresent()) {
			result.rejectValue("email", "Unique", "Account with this email already exists");
		}
		
		if(!newMember.getPassword().equals(newMember.getConfirm())) {
			result.rejectValue("confirm", "matches", "Passwords do not match");
		}

		if(result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newMember.getPassword(), BCrypt.gensalt());
		newMember.setPassword(hashed);
		newMember = memberRepo.save(newMember);
		System.out.println("New user created with ID: " + newMember.getId());
		
		return newMember;
		
	}
	
	// Member Login
	
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
	
	// Get One Member
	
	public Member oneMember(Long id) {
		
		System.out.println(id);
		
		Member member = memberRepo.findById(id).orElse(null);
		System.out.println(member.getFirstName());
		
		return member;
	}
	
	// Get Mutual Aid for One Member
	
	
	
	
	
	

}
