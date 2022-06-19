package com.codingdojo.mutualade.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.mutualade.services.OrgAidService;
import com.codingdojo.mutualade.services.OrgService;
import com.codingdojo.mutualade.services.UserService;

@Controller
public class OrgController {
	
	@Autowired
	OrgService orgService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrgAidService orgAidService;
	
	//GET Mapping
	
	@GetMapping("/org/profile/{id}")
	public String orgProfile(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		model.addAttribute("org", orgService.oneOrg(id));
		model.addAttribute("orgAid", orgService.getOrgAid(id));
		
		
		return "OrgProfile.jsp";
	}
	
	@GetMapping("/org/page/{id}")
	public String orgPage(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		model.addAttribute("org", orgService.oneOrg(id));
		model.addAttribute("orgAid", orgService.getOrgAid(id));
		
		return "OrgProfile.jsp";
	}
	
	

}
