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
@RequestMapping("/admin")
public class ContactAdminController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/list")
	public ModelAndView showContactsList() throws ContactException {
		return new ModelAndView("contactsPage","contacts",contactService.getAllContacts());
	}
	
	@GetMapping("/newContact")
	public ModelAndView showContactFormForAdd() {
		ModelAndView mv = new ModelAndView("contactFormPage","contact",new Contact());
		mv.addObject("isNew",true);
		return mv;
	}
	
	@GetMapping("/editContact")
	public ModelAndView showContactFormForEdit(@RequestParam("cid") int contactId) throws ContactException {
		Contact contact = contactService.getContact(contactId);
		ModelAndView mv = new ModelAndView("contactFormPage","contact",contact);
		mv.addObject("isNew",false);
		return mv;
	}
	
	@PostMapping("/addContact")
	public ModelAndView doAddContact(@ModelAttribute("contact") @Valid Contact contact,BindingResult result) throws ContactException {
		ModelAndView mv =null;
		
		if(result.hasErrors()) {
			mv = new ModelAndView("contactFormPage","contact",contact);
			mv.addObject("isNew",true);
		}else {
			contactService.add(contact);
			mv = new ModelAndView("index","msg","Contact Saved Succesfully!");
		}
		
		return mv;
	}
	
	@PostMapping("/saveContact")
	public ModelAndView doSaveContact(@ModelAttribute("contact") @Valid Contact contact,BindingResult result) throws ContactException {
		ModelAndView mv =null;
		
		if(result.hasErrors()) {
			mv = new ModelAndView("contactFormPage","contact",contact);
			mv.addObject("isNew",false);
		}else {
			contactService.save(contact);
			mv = new ModelAndView("index","msg","Contact Saved Succesfully!");
		}
		
		return mv;
	}
	
	@GetMapping("/deleteContact")
	public ModelAndView doDeleteContact(@RequestParam("cid") int contactId) throws ContactException {
		contactService.deleteContact(contactId);
		return new ModelAndView("index","msg","Contact Deleted Succesfully!");
	}
	
	@ModelAttribute("allGroups")
	public List<String> getGroups(){
		return Arrays.asList(new String[] {"Family","Work","Gym","Metro","Helpers"});
	}
	
}
