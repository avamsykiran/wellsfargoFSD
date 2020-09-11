package com.wellsfargo.fsd.swbd.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.swbd.service.GreetService;

@Controller
public class CommonController {
	
	@Autowired
	private GreetService greetService;

	@GetMapping({"","/","/home"})
	public String homeAction() {
		return "home-page";
	}
	
	@GetMapping("/greet")
	public ModelAndView acceptUsername(@RequestParam("unm") String userName) {
		return new ModelAndView("home-page", "msg", greetService.doGreet(userName));
	}	
	
	@RequestMapping("/header") //allows GET,POST or any other http method
	public ModelAndView headerAction() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("header-segment");
		mv.addObject("today",LocalDateTime.now());
		mv.addObject("webTitle","Spring Boot MVC App");
		
		return mv;
	}
}
