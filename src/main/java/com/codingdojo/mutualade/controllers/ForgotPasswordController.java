package com.codingdojo.mutualade.controllers;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mutualade.Utility;
import com.codingdojo.mutualade.models.User;
import com.codingdojo.mutualade.services.UserNotFoundException;
import com.codingdojo.mutualade.services.UserService;

import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {
	
	public void sendEmail(String recipientEmail, String link)
	        throws MessagingException, UnsupportedEncodingException {
	    MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("contact@shopme.com", "Shopme Support");
	    helper.setTo(recipientEmail);
	     
	    String subject = "Here's the link to reset your password";
	     
	    String content = "<p>Hello,</p>"
	            + "<p>You have requested to reset your password.</p>"
	            + "<p>Click the link below to change your password:</p>"
	            + "<p><a href=\"" + link + "\">Change my password</a></p>"
	            + "<br>"
	            + "<p>Ignore this email if you do remember your password, "
	            + "or you have not made the request.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	    
	    System.out.println(content);
	     
	    mailSender.send(message);
	}
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/forgot_password")
	public String showForgotPasswordForm() {
		
		return "ForgotPassword.jsp";
		
	}
	
	@PostMapping("/forgot_password")
	public String processForgotPassword(
			HttpServletRequest request, 
			Model model
			) {
		String email = request.getParameter("email");
		String token = RandomString.make(30);
		
		System.out.println(token);
		System.out.println(email);
		
		try {
			userService.updateResetPasswordToken(token, email);
			String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
			System.out.println(resetPasswordLink);
			sendEmail(email, resetPasswordLink);
			model.addAttribute("message", "We have sent a reset password link to your email. Please check");
		} catch (UserNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("error", "Error while sending email");
		}
		
		
		
		return "forgot_password_form";
	}
	
	
	@GetMapping("/reset_password")
	public String showResetPasswordForm(
			@Param(value = "token") String token, 
			Model model) {
	    User user = userService.getByResetPasswordToken(token);
	    model.addAttribute("token", token);
	     
	    if (user == null) {
	        model.addAttribute("message", "Invalid Token");
	        return "message";
	    }
	     
	    return "ResetPasswordForm.jsp";
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