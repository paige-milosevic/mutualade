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

import com.codingdojo.mutualade.models.AidRequest;
import com.codingdojo.mutualade.services.AidService;
import com.codingdojo.mutualade.services.UserService;

@Controller
public class AidController {

	@Autowired
	
	UserService userService;
	
	@Autowired
	AidService aidService;
	
	// GET Mapping
	
	@GetMapping("/aid/new")
	public String newAid(
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		model.addAttribute("aid", new AidRequest());
	
		return "NewAid.jsp";
	}
	
	@GetMapping("/aid/{id}")
	public String oneAid(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		model.addAttribute("aid", aidService.oneAidReq(id));
		
		
		return "OneAid.jsp";
	}
	
	@GetMapping("/aid/edit/{id}")
	public String editAid(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		model.addAttribute("aid", aidService.oneAidReq(id));
		
		return "EditAid.jsp";
		
	}
	
	
	// POST Mapping
	
	@PostMapping("/aid/create")
	public String createAid(
			@Valid @ModelAttribute("aid") AidRequest aidReq,
			BindingResult result,
			Model model,
			HttpSession session
			) throws ParseException {
		
		
		aidService.createAidReq(aidReq);
		
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		if(result.hasErrors()) {
			model.addAttribute("aid", aidReq);
			System.out.println(result);
			return "NewAid.jsp";
		}
		
		return "redirect:/dashboard";
		
	}
	
	// PUT Mapping
	
	@PutMapping("/aid/update/{id}")
	public String updateAid(
			@Valid @ModelAttribute("aid") AidRequest aid,
			BindingResult result,
			Model model,
			HttpSession session
			) throws ParseException {
		
		aidService.updateAidReq(aid);
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "EditAid.jsp";
		}
		
		
		return "redirect:/aid/{id}";
	}
	
	// Delete Mapping
	@DeleteMapping("/aid/delete/{id}")
	public String destroy(
			@PathVariable("id") Long id
			) {
		
		aidService.deleteAid(id);
		return "redirect:/dashboard";
	}
}
