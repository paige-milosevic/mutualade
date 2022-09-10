package com.codingdojo.mutualade.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.mutualade.models.LoginUser;
import com.codingdojo.mutualade.models.User;
import com.codingdojo.mutualade.repos.UserRepo;

@Service
public class UserService {
	
	@Autowired 
	UserRepo userRepo;
	
	//Register User
	
	public User register(User newUser, BindingResult result) {
		
		Optional<User> userLookUp = userRepo.findByEmail(newUser.getEmail());
		
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
		newUser = userRepo.save(newUser);
		System.out.println("New user created with ID: " + newUser.getId());
		
		return newUser;
		
	}
	
	// Login User
	
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
		
		System.out.println(user.getId());
		
		return user;
		
	}
	
	// Get One User
	
	public User oneUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	
}
