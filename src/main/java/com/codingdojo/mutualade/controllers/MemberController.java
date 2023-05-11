package com.codingdojo.mutualade.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.mutualade.services.MemberService;
import com.codingdojo.mutualade.services.UserService;

@Controller 
public class MemberController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MemberService memberService;
	
	// GET Mapping
	
	@GetMapping("/member/profile/{id}")
	public String memberProfile(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		model.addAttribute("member", memberService.oneMember(id));
		model.addAttribute("aid", memberService.getMemberAid(id));
		
		
		return "MemberProfile.jsp";
	}
	

}
