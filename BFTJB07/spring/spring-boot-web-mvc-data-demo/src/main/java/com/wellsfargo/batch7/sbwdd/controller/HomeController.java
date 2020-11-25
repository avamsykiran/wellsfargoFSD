package com.wellsfargo.batch7.sbwdd.controller;

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
		return mv;
	}

}
