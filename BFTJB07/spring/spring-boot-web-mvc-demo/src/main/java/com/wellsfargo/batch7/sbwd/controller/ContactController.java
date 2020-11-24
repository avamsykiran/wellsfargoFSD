package com.wellsfargo.batch7.sbwd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch7.sbwd.model.ContactModel;

@Controller
@RequestMapping("/contact")
public class ContactController {

	//@RequestMapping(value="",method=RequestMethod.GET)
	@GetMapping
	//public String contactFormAction() {
	//return "contact/contact-form-page";
	//}
	public ModelAndView contactFormAction() {
		return new ModelAndView("contact/contact-form-page","contact",new ContactModel());
	}
	
	@PostMapping
	public ModelAndView contactAction(@ModelAttribute ContactModel contact) {
		return new ModelAndView("contact/contact-page","contact",contact);
	}
}
