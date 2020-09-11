package com.wellsfargo.fsd.swbd.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.swbd.model.Item;
import com.wellsfargo.fsd.swbd.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item")
	/*
	 * public String showItemForm() { return "item-form-page"; }
	 */
	public ModelAndView showItemForm() { 
		return new ModelAndView("item-form-page","item",new Item()); 
	}
	
	@PostMapping("/item")
	public ModelAndView acceptItem(@ModelAttribute Item itemModel) {
		itemService.computeGSTandSellingPrice(itemModel);
		return new ModelAndView("item-output-page","item",itemModel);
	}
	
	@ModelAttribute("categories")
	public List<String> getCategories(){
		return Arrays.asList(new String[] {"ORNIMENT","AGRO","DAIRY","CLOTHS","OTHERS"} );
	}
}
