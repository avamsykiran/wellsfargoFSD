package com.wellsfargo.batch5.sbwdd.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping({"","/","/home"})
	public String homeAction() {
		return "home-page";
	}
	
	@RequestMapping("/header")
	public ModelAndView headerAction() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("header-fragment");
		mv.addObject("appTitle","Library Management Portal");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("auth",auth);
		}
							
		return mv;
	}
}
