package com.codingdojo.mutualade.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.mutualade.services.UserService;

@Controller
public class MemberController {
	
	@Autowired
	UserService userService;
	
	/* GET Mapping */
	
	// Get user's profile
	
	@GetMapping("/member/profile")
	public String memProfile(
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		
		
		return "MemberProfile.jsp";

	}
	
	// Update Member Information
	
	@GetMapping("/member/edit/{id}")
	public String editMemProfile(
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		
		
		return "MemberEdit.jsp";

	}
	
	
	

}
