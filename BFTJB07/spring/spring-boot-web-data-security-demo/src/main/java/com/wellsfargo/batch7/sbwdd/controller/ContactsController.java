package com.wellsfargo.batch7.sbwdd.controller;

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

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;
import com.wellsfargo.batch7.sbwdd.model.AddressGroupModel;
import com.wellsfargo.batch7.sbwdd.model.ContactModel;
import com.wellsfargo.batch7.sbwdd.service.AddressGroupService;
import com.wellsfargo.batch7.sbwdd.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AddressGroupService groupService;
	
	@GetMapping
	public ModelAndView contactsAction() throws AddressBookException {
		return new ModelAndView("contacts/contacts-page","contacts",contactService.getAll());
	}
	
	@GetMapping("/delete")
	public String deleteAction(@RequestParam("cid")long cId) throws AddressBookException {
		contactService.delete(cId);
		return "redirect:/contacts";
	}
	 
	@ModelAttribute("groups")
	public List<AddressGroupModel> getAllGroups() throws AddressBookException{
		return groupService.getAll();
	}
	
	@GetMapping("/new")
	public ModelAndView newContactAction() {
		ModelAndView mv = new ModelAndView("contacts/contact-form-page","contact",new ContactModel());
		mv.addObject("isNew",true);
		return mv;
	}
	
	@GetMapping("/edit")
	public ModelAndView editContactAction(@RequestParam("cid")long cId) throws AddressBookException {
		ContactModel contact = contactService.get(cId);
		ModelAndView mv = new ModelAndView("contacts/contact-form-page","contact",contact);
		mv.addObject("isNew",false);
		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView addContactAction(
			@ModelAttribute("contact") @Valid ContactModel contact,
			BindingResult result
			) throws AddressBookException {
		ModelAndView mv=null;	
		
		if(result.hasErrors()) {
			mv = new ModelAndView("contacts/contact-form-page","contact",contact);
			mv.addObject("isNew",true);
		}else {
			contactService.add(contact);
			mv = new ModelAndView("redirect:/contacts");
		}
		
		return mv;
	}
	
	@PostMapping("/update")	
	public ModelAndView updateContactAction(
			@ModelAttribute("contact") @Valid ContactModel contact,
			BindingResult result
			) throws AddressBookException {
		ModelAndView mv=null;	
		
		if(result.hasErrors()) {
			mv = new ModelAndView("contacts/contact-form-page","contact",contact);
			mv.addObject("isNew",false);
		}else {
			contactService.update(contact);
			mv = new ModelAndView("redirect:/contacts");
		}
		
		return mv;
	}
}
