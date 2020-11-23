package com.wellsfargo.batch7.sbwd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

	/*
	 * http://localhost:9090
	 * http://localhost:9090/
	 * http://localhost:9090/home
	 */
	@RequestMapping(value={"","/","/home"},method=RequestMethod.GET)
	public String homeAction(){
		return "home-page";
	}
}
