package com.codingdojo.mutualade.controllers;

import java.text.ParseException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mutualade.models.OrgAid;
import com.codingdojo.mutualade.services.OrgAidService;
import com.codingdojo.mutualade.services.UserService;

@Controller
public class OrgAidController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrgAidService orgAidService;
	
	
	// GET Mapping
	
	@GetMapping("/org/make/aid")
	public String makeaid(
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		model.addAttribute("orgAid", new OrgAid());
		
		return "MakeAid.jsp";
	}
	
	//POST Mapping
	
	@PostMapping("/org/create/aid")
	public String createaid(
			@Valid @ModelAttribute("orgAid") OrgAid orgAid,
			BindingResult result,
			Model model,
			HttpSession session
			) throws ParseException {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		if(result.hasErrors()) {
			model.addAttribute("orgAid", orgAid);
			System.out.println(result);
			return "MakeAid.jsp";
		}
		
		orgAidService.createOrgAid(orgAid);
		
		return "redirect:/dashboard";
	}
	
}
