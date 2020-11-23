package com.wellsfargo.batch7.sbwd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/commons")
public class CommonsController {

	/*
	 * http://localhost:9090/commons/header
	 */
	@RequestMapping("/header")
	public String headerAction() {
		return "commons/header-page";
	}
	
	/*
	 * http://localhost:9090/commons/aboutUs
	 */
	@RequestMapping(value="/aboutUs",method=RequestMethod.GET)	
	public String aboutUsAction() {
		return "commons/about-us-page";
	}
		
	/*
	 * http://localhost:9090/commons/contactUs
	 */
	@RequestMapping(value="/contactUs",method=RequestMethod.GET)
	public ModelAndView contactUsAction() {
		ModelAndView  mv = new ModelAndView ();
		
		mv.setViewName("commons/contact-us-page");
		mv.addObject("mobile", new String[] {"9052224753","9948016004","9550204753"});
		mv.addObject("mail", "vamsy.kiran@iiht.co.in");

		return mv;
	}
	
}
