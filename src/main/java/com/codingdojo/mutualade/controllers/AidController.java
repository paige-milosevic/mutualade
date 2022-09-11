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
	
	/* GET Mapping */
	
	
	// Maps to Create Aid Request Form
	
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
	
	// Maps to Get One Aid Request Page
	
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
	
	// Maps to Edit One Aid Request Form
	
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
	
	/* POST Mapping */
	
	// Maps a New Aid Request to be Created
	
	@PostMapping("/aid/create")
	public String createAid(
			@Valid @ModelAttribute("aid") AidRequest aidReq,
			BindingResult result,
			Model model,
			HttpSession session
			) throws ParseException {
		
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		if(result.hasErrors()) {
			model.addAttribute("aid", aidReq);
			System.out.println(result);
			return "NewAid.jsp";
		}
		
		aidService.createAidReq(aidReq);
		System.out.println(aidReq.getMember());
		
		return "redirect:/dashboard";
		
	}
	

	/* PUT Mapping */
	
	// Maps an Aid Request to be Updated
	
	/* When going to update the aid request, the title will not 
	 * re-populate and the user.firstName doesn't not populate after
	 * the PUT map request, if I add the model attribute before 
	 * redirecting it will re-populate the title not session user,
	 *  but does not give error messages on client side. When I 
	 *  redirect the route, I can't get error messages to show, 
	 *  but the user.firstName populates as well as the original
	 *  title. */
	
	@PutMapping("/aid/update/{id}")
	public String updateAid(
			@Valid @ModelAttribute("aid") AidRequest aidNew,
			BindingResult result,
			Model model,
			HttpSession session
			) throws ParseException {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		
		AidRequest aid = aidService.oneAidReq(aidNew.getId());
		System.out.println(aid.getTitle());
		
//		if(result.hasErrors()) {
//			model.addAttribute("aid", aid);
//			model.addAttribute("errors", result);
//			System.out.println(aid.getTitle());
//			System.out.println(result);
//			return "redirect:/aid/edit/{id}";
//		}
		
		if(result.hasErrors()) {
//			model.addAttribute("aid", aid);
			System.out.println(aid.getTitle());
			System.out.println(result);
			return "EditAid.jsp";
		}
		
		aidService.updateAidReq(aidNew);
		
		
		return "redirect:/aid/{id}";
	}
	
	
	/* DELETE Mapping */
	
	// Deletes One Aid Request 
	
	@DeleteMapping("/aid/delete/{id}")
	public String destroy(
			@PathVariable("id") Long id
			) {
		
		aidService.deleteAid(id);
		return "redirect:/dashboard";
	}
}
