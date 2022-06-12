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
import com.codingdojo.mutualade.models.User;
import com.codingdojo.mutualade.services.AidService;
import com.codingdojo.mutualade.services.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@Autowired
	AidService aidService;
	
	//GET Requests
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
		
		return "Dashboard.jsp";
		
	}
	
	// POST Requests
	
	@PostMapping("/register")
	public String reg(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		
		User user = userService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			System.out.println(result);
			return "Login.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
		
	}
	
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

