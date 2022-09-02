package com.codingdojo.mutualade.controllers;

import java.text.ParseException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.mutualade.models.OrgAid;
import com.codingdojo.mutualade.services.OrgAidService;
import com.codingdojo.mutualade.services.OrgService;
import com.codingdojo.mutualade.services.UserService;

@Controller
public class OrgAidController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrgAidService orgAidService;
	
	@Autowired
	OrgService orgService;
	
	
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
		model.addAttribute("org", orgService.oneOrg((Long)session.getAttribute("userId")));
		model.addAttribute("orgAid", new OrgAid());
		
		return "MakeAid.jsp";
	}
	
	@GetMapping("/orgaid/{id}")
	public String getOneAid(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		model.addAttribute("orgAid", orgAidService.oneOrgAid(id));
		
		return "OneOrgAid.jsp";
	}
	
	
	@GetMapping("org/aid/update/{id}")
	public String updateOneAid(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		model.addAttribute("orgAid", orgAidService.oneOrgAid(id));
		
		return "UpdateOrgAid.jsp";
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
	
	// PUT Mapping
	
	@PutMapping("/org/aid/update/{id}")
	public String updateOrgAid(
			@Valid @ModelAttribute("aid") OrgAid orgAid,
			BindingResult result,
			Model model,
			HttpSession session
			) throws ParseException {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "UpdateOrgAid.jsp";
		}	
		
		orgAidService.updateOrgAid(orgAid);		
		
		return "redirect:/dashboard";
	}
	
	// DELETE Mapping
	
	@DeleteMapping("/org/aid/delete/{id}")
	public String destroy(
			@PathVariable("id") Long id
			) {
		
		orgAidService.deleteAid(id);
		
		return "redirect:/dashboard";
	}
	
	
	
	
}
