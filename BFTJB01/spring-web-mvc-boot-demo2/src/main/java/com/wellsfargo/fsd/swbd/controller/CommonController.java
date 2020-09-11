package com.wellsfargo.fsd.swbd.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

	@GetMapping({"","/","/home"})
	public String defaultAction() {
		return "home";
	}
	
	@RequestMapping("/header") //allows get,post and all other http methods
	public ModelAndView headerAction() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("header");
		mv.addObject("title", "My SpringBoot MVC App");
		mv.addObject("today",LocalDateTime.now());
		
		return mv;
	}
	
	@GetMapping("/greet")
	public ModelAndView doGreet(@RequestParam("unm") String userName) {
		return new ModelAndView("home","msg","Hello! " +userName);
	}
}
