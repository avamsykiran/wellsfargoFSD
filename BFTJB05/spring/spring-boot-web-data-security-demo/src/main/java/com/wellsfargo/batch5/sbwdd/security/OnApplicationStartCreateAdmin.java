package com.wellsfargo.batch5.sbwdd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.batch5.sbwdd.entity.Librarian;
import com.wellsfargo.batch5.sbwdd.repo.LibrarianRepo;

@Component
public class OnApplicationStartCreateAdmin {

	@Autowired
	private LibrarianRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@EventListener
	public void checkAndCreateAdmin(ApplicationStartedEvent event) {
		if(!repo.existsByUserName("superUser")) {
			repo.save(new Librarian(null, "superUser", encoder.encode("superUser"),"LIBRARIAN", "Srinivas", 85420.0));
		}
	}
}
