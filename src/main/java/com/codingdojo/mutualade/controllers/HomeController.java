package com.codingdojo.mutualade.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mutualade.models.LoginUser;
import com.codingdojo.mutualade.models.Member;
import com.codingdojo.mutualade.models.Organization;
import com.codingdojo.mutualade.models.User;
import com.codingdojo.mutualade.services.AidService;
import com.codingdojo.mutualade.services.MemberService;
import com.codingdojo.mutualade.services.OrgService;
import com.codingdojo.mutualade.services.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@Autowired
	AidService aidService;
	
	@Autowired
	OrgService orgService;
	
	@Autowired
	MemberService memService;
	
	
	//GET Requests
	
	// Member Login & Reg
	
	@GetMapping("/")
	public String index(Model model,
			HttpSession session
			) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		if (session.getAttribute("userId") != null) {
			return "redirect:/dashboard";
		} 
		
		return "Login.jsp";
	}
	
	// Org Login & Reg
	
	@GetMapping("/org")
	public String indexOrg(Model model,
			HttpSession session
			) {
		model.addAttribute("newUser", new Organization());
		model.addAttribute("newLogin", new LoginUser());
		
		if (session.getAttribute("userId") != null) {
			return "redirect:/dashboard";
		} 
		
		return "LoginOrg.jsp";
	}
	
		
		
		
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(
			Model model, 
			HttpSession session
			) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		
		model.addAttribute("user", userService.oneUser((Long)session.getAttribute("userId")));
		model.addAttribute("mutualAid", aidService.allAidRequests());
		model.addAttribute("organization", orgService.allOrgs());
		
		
		
		
		
		return "Dashboard.jsp";
		
	}
	
	// POST Requests
	
	// Member Registration
	
	@PostMapping("/register")
	public String reg(
			@Valid @ModelAttribute("newUser") Member newUser,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		
		memService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			System.out.println(result);
			return "Login.jsp";
		}
		
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
		
	}
	
	// Org Registration
	
	@PostMapping("/org/register")
	public String reg(
			@Valid @ModelAttribute("newUser") Organization newOrg,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		
		orgService.register(newOrg, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			System.out.println(result);
			return "LoginOrg.jsp";
		}
		
		session.setAttribute("userId", newOrg.getId());
		return "redirect:/dashboard";
		
	}
	
	// Login
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		
		User user = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			System.out.println(result);
			return "Login.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		
		return "redirect:/dashboard";
	}
	


}

