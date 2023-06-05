package com.codingdojo.mutualade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mutualade.services.UserService;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/forgot_password")
	public String showForgotPasswordForm() {
		return "ForgotPassword.jsp";
		
	}
	
//	@PostMapping("/forgot_password")
//	public String processForgotPassword() {
//		
//	}
//	
//	public void sendEmail() {
//		
//	}
//	
//	@GetMapping("/reset_password")
//	public String showResetPasswordForm() {
//		
//	}
//	
//	@PostMapping("/reset_password")
//	public String processResetPassword() {
//		
//	}
	
	
	
}