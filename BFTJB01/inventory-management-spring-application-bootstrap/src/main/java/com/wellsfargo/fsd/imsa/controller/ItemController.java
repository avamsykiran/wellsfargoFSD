package com.wellsfargo.fsd.imsa.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.imsa.entity.Item;
import com.wellsfargo.fsd.imsa.exception.ImsException;
import com.wellsfargo.fsd.imsa.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/list")
	public ModelAndView shopItemsList() throws ImsException {
		return new ModelAndView("itemsListPage","items",itemService.getAllItems());
	}
	
	@GetMapping("/newItem")
	public ModelAndView showItemFormForAdding() {
		ModelAndView mv = new ModelAndView("itemFormPage","item",new Item());
		mv.addObject("isNew",true);				
		return mv;
	}
	
	@ModelAttribute("units")
	public List<String> getUnits(){
		return Arrays.asList(new String[] {"Kg","Mtr","Ltr","Packet","Piece"});
	}
	
	@PostMapping("/addItem")
	public ModelAndView doAddItem(@ModelAttribute("item") @Valid Item item,BindingResult result) throws ImsException {
		ModelAndView mv=null;
		
		if(result.hasErrors()) {
			mv =new ModelAndView("itemFormPage","item",item);
			mv.addObject("isNew",true);
		}else {
			itemService.add(item);
			mv =new ModelAndView("index","msg","Item is saved!");
		}
		
		return mv;
	}
	
	@GetMapping("/editItem")
	public ModelAndView showItemFormForEditing(@RequestParam("icode") int icode) throws ImsException {
		Item item = itemService.getItemById(icode);
		ModelAndView mv = new ModelAndView("itemFormPage","item",item);
		mv.addObject("isNew",false);				
		return mv;
	}
	
	@PostMapping("/saveItem")
	public ModelAndView doSaveItem(@ModelAttribute("item") @Valid Item item,BindingResult result) throws ImsException {
		ModelAndView mv=null;
		
		if(result.hasErrors()) {
			mv =new ModelAndView("itemFormPage","item",item);
			mv.addObject("isNew",false);
		}else {
			itemService.save(item);
			mv =new ModelAndView("index","msg","Item is saved!");
		}
		
		return mv;
	}
	
	@GetMapping("/deleteItem")
	public ModelAndView doDelteItem(@RequestParam("icode") int icode) throws ImsException {
		itemService.deleteItem(icode);
		return new ModelAndView("index","msg","Item is deleted!");
				
	}
}
