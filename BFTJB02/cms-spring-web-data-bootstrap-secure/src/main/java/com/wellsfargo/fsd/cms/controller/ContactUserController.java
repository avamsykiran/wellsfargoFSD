package com.wellsfargo.fsd.cms.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;
import com.wellsfargo.fsd.cms.service.ContactService;

@Controller
@RequestMapping("/user")
public class ContactUserController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/list")
	public ModelAndView showContactsList() throws ContactException {
		return new ModelAndView("contactsPage","contacts",contactService.getAllContacts());
	}
	
}
