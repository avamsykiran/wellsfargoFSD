package com.wellsfargo.batch7.sbwdd.controller;

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
import com.wellsfargo.batch7.sbwdd.service.AddressGroupService;

@Controller
@RequestMapping("/groups")
public class AddressGroupController {

	@Autowired
	private AddressGroupService agService;
	
	@GetMapping
	public ModelAndView groupsAction() throws AddressBookException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("groups/groups-page");
		mv.addObject("groups",agService.getAll());
		mv.addObject("group",new AddressGroupModel());
		return mv;
	}
	
	@GetMapping("/delete")
	public String deleteAction(@RequestParam("gid") int groupId) throws AddressBookException {
		agService.delete(groupId);
		return "redirect:/groups";
	}
	
	@PostMapping("/add")
	public ModelAndView addAction(
			@ModelAttribute("group") @Valid AddressGroupModel group,
			BindingResult result) throws AddressBookException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("groups/groups-page");
		
		if(result.hasErrors()) {
			mv.addObject("group",group);	
		}else {
			agService.add(group);
			mv.addObject("group",new AddressGroupModel());
		}
		
		mv.addObject("groups",agService.getAll());
		return mv;
	}
}
