package com.wellsfargo.fsd.swbd.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.swbd.model.Item;
@Controller
public class ItemController {
	
	@GetMapping("/items")
	public ModelAndView showItemForm() {
		return new ModelAndView("item-form-page","item",new Item());
	}
	
	@PostMapping("/items")
	public ModelAndView recevieITemForm(@ModelAttribute Item item) {
		return new ModelAndView("item-output-page","item",item);
	}

	@ModelAttribute("categories")
	public List<String> getCategories(){
		return Arrays.asList(new String[] {"Pulses","Cerals","Beverages","Others"});
	}
}
