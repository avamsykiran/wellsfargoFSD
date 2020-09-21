package com.wellsfargo.fsd.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

	@GetMapping({"","/","/home"})
	public String showHome() {
		return "index";
	}
	
	@RequestMapping("/header")
	public String showHeader() {
		return "header";
	}
}
