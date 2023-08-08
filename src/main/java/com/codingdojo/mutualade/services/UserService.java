package com.codingdojo.mutualade.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	
	// Update Reset Password
	
	@Transactional(readOnly = true)
	public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
		
		Optional<User> userLookUp = userRepo.findByEmail(email);
		
		User user = userLookUp.get();
		System.out.println(user);
		
		if (user != null) {
			
			user.setResetPasswordToken(token);
			System.out.println(user.getResetPasswordToken());
			userRepo.save(user);
			
			
		} else {
			throw new UserNotFoundException("Could not find any user with the email " + email);
		}
			
	}
	
	// Get by Reset Password Token
	
	public User getByResetPasswordToken(String token) {
		return userRepo.findByResetPasswordToken(token);
	}
	
	// Update User Password
	
	public void updatePassword(User user, String newPassword) {
		
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		user.setResetPasswordToken(null);
		user = userRepo.save(user);
		
		
	}
	
	// Get One User
	
	public User oneUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	
	
}
