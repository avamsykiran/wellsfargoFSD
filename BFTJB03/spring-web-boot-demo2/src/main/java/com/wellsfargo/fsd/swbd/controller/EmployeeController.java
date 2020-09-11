package com.wellsfargo.fsd.swbd.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.swbd.model.Employee;
import com.wellsfargo.fsd.swbd.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/emp")
	/*
	 * public String showEmpForm() { return "emp-form-page"; }
	 */	
	public ModelAndView showEmpForm() {
		return new ModelAndView("emp-form-page","emp",new Employee());
	}
	
	@ModelAttribute("designations")
	public List<String> getDesignation(){
		return Arrays.asList(new String[] {"General Manager","Asst., Geenral Manager","Manager","Assosiate"});
	}
	
	@PostMapping("/emp")
	public ModelAndView acceptEmployee(@ModelAttribute Employee empModel) {
		empService.computeAllowences(empModel);
		return new ModelAndView("emp-output-page","emp",empModel);
	}
}
