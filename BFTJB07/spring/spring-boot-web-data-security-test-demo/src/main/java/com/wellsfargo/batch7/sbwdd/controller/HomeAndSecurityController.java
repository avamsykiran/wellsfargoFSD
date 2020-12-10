package com.wellsfargo.batch7.sbwdd.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;
import com.wellsfargo.batch7.sbwdd.model.AdbSubscriberRegistrationModel;
import com.wellsfargo.batch7.sbwdd.security.UserDetailsServiceImpl;

@Controller
public class HomeAndSecurityController {

	@Autowired
	private UserDetailsServiceImpl userService;

	@GetMapping({ "", "/", "/home" })
	public String homeAction() {
		return "home-page";
	}

	@RequestMapping("/header")
	public ModelAndView headerAction() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("header-fragment");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {			
			mv.addObject("role",auth.getAuthorities().stream().findFirst().get().getAuthority());
			mv.addObject("userName",auth.getName());
		}

		return mv;
	}

	@GetMapping("/login")
	public String loginAction() {
		String view = "login-page";

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			view = "redirect:/home";
		}

		return view;
	}

	@GetMapping("/register")
	public ModelAndView registerAction() {
		return new ModelAndView("register-form-page", "user", new AdbSubscriberRegistrationModel());
	}

	@PostMapping("/register")
	public ModelAndView registerAction(@ModelAttribute("user") @Valid AdbSubscriberRegistrationModel user,
			BindingResult result) throws AddressBookException {
		ModelAndView mv = null;
		if (result.hasErrors()) {
			mv = new ModelAndView("register-form-page", "user", user);
		} else {
			userService.register(user);
			mv = new ModelAndView("redirect:/login");
		}

		return mv;
	}
}
