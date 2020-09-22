package com.wellsfargo.fsd.imsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.imsa.exception.ImsException;
import com.wellsfargo.fsd.imsa.service.ItemService;

@Controller
@RequestMapping("/user")
public class ItemsForUsersController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/list")
	public ModelAndView shopItemsList() throws ImsException {
		return new ModelAndView("itemsListPage","items",itemService.getAllItems());
	}
}
