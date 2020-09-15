package com.wellsfargo.fsd.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;
import com.wellsfargo.fsd.cms.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/list")
	public ModelAndView showContactsList() throws ContactException {
		return new ModelAndView("contactsPage","contacts",contactService.getAllContacts());
	}
	
	@GetMapping("/newContact")
	public ModelAndView showContactForm() {
		ModelAndView mv = new ModelAndView("contactFormPage","contact",new Contact());
		mv.addObject("isNew",true);
		return mv;
	}
}
