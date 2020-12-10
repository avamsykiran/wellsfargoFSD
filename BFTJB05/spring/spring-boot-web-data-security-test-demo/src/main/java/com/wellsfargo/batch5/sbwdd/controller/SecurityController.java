package com.wellsfargo.batch5.sbwdd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.sbwdd.exception.LibraryException;
import com.wellsfargo.batch5.sbwdd.model.RegisterLibraryMemberModel;
import com.wellsfargo.batch5.sbwdd.security.UserDetailsServiceImpl;

@Controller
public class SecurityController {
	
	@Autowired
	private UserDetailsServiceImpl userService;
	
	@GetMapping("/login")
	public String gotoLogin() {
		String view="login-page";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			view="redirect:/home";
		}

		return view; 
	}
	
	@GetMapping("/register")
	public ModelAndView showRegisterationForm() {
		return  new ModelAndView("register-form-page","user",new RegisterLibraryMemberModel());
	}
	
	@PostMapping("/register")
	public ModelAndView doRegisteration(
			@ModelAttribute("user") @Valid RegisterLibraryMemberModel user,
			BindingResult result) throws LibraryException {
		ModelAndView mv = null;
		if(result.hasErrors()) {
			mv = new ModelAndView("register-form-page","user",user);
		}else {
			userService.registerMember(user);
			mv=new ModelAndView("redirect:/home");
		}
		return  mv;
	}
}
