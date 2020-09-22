package com.wellsfargo.fsd.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.fsd.cms.dao.CMSUserRepo;
import com.wellsfargo.fsd.cms.entity.CMSUser;

@Component
public class AppStartUpEventHandler {

	@Autowired
	private CMSUserRepo repo;
	
	@Autowired
	private PasswordEncoder penc;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		if(!repo.existsByUserName("admin")) {
			repo.save(new CMSUser(null, "admin", "admin", penc.encode("admin"),"ADMIN"));
		}
	}
}
