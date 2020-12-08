package com.wellsfargo.batch7.sbwdd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.batch7.sbwdd.entity.AdbEmployeeEntity;
import com.wellsfargo.batch7.sbwdd.repo.AdbEmployeeRepo;

@Component
public class OnAppStartUpCreateSuperUser {

	@Autowired
	private AdbEmployeeRepo empRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@EventListener
	public void createSuperUserOnStartUp(ApplicationStartedEvent event) {
		if(!empRepo.existsByUserName("superEmp")) {
			empRepo.save(new AdbEmployeeEntity(null, 
					"superEmp", encoder.encode("superEmp"), "EMPLOYEE", "Srinivas", 450000.0));
		}
	}
}
