package com.codingdojo.mutualade.controllers;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mutualade.models.LoginUser;
import com.codingdojo.mutualade.services.UserService;

import net.bytebuddy.utility.RandomString;

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
	
	@PostMapping("/forgot_password_post")
	public String processForgotPassword(
			HttpServletRequest request, 
			Model model
			) {
		String email = request.getParameter("email");
		String token = RandomString.make(30);
		
		try {
			userService.updateResetPasswordToken(token, email);
			String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
			sendEmail(email, resetPasswordLink);
			model.addAttribute("message", "We have sent a reset password link to your email. Please check");
		} catch (CustomerNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("error", "Error while sending email");
		}
		
		
		
		return "forgot_password_form";
	}
	
	
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