package com.wellsfargo.fsd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.fsd.lms.dao.LMSUserRepo;
import com.wellsfargo.fsd.lms.entity.LMSUser;

@Component
public class AppStartUpEventHandler {

	@Autowired
	private LMSUserRepo repo;
	
	@Autowired	
	private PasswordEncoder penc;
	
	@EventListener
	public void onAppStartup(ApplicationReadyEvent event) {
		if(!repo.existsByUserName("admin")) {
			repo.save(new LMSUser("admin", "admin",penc.encode("admin") , "ADMIN"));
		}
	}
}
