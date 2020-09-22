package com.wellsfargo.fsd.imsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.fsd.imsa.dao.IMSUserRepo;
import com.wellsfargo.fsd.imsa.entity.IMSUser;

@Component
public class AppStartUpEventHandler {

	@Autowired
	private IMSUserRepo repo;
	
	@Autowired
	private PasswordEncoder penc;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {

		IMSUser user = repo.findByUserName("admin");
		
		if(user==null) {
			user = new IMSUser();
			user.setUserName("admin");
			user.setEncodedPassword(penc.encode("admin"));
			user.setRole("ADMIN");
			repo.save(user);
		}
	}
}
