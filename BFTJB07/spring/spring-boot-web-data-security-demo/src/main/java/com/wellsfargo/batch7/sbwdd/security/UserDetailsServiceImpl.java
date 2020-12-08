package com.wellsfargo.batch7.sbwdd.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch7.sbwdd.entity.AdbUserEntity;
import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;
import com.wellsfargo.batch7.sbwdd.model.AdbSubscriberRegistrationModel;
import com.wellsfargo.batch7.sbwdd.repo.AdbSubscriberRepo;
import com.wellsfargo.batch7.sbwdd.repo.AdbUserRepo;
import com.wellsfargo.batch7.sbwdd.util.EMParser;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AdbUserRepo userRepo;
	
	@Autowired
	private AdbSubscriberRepo subRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(!userRepo.existsByUserName(username)) {
			throw new UsernameNotFoundException("invlaid user credits!");
		}
		
		AdbUserEntity adbUser = userRepo.findByUserName(username);
		
		return new User(adbUser.getUserName(), adbUser.getPassword(), 
				Collections.singletonList(new SimpleGrantedAuthority(adbUser.getRole())));
	}

	public void register(AdbSubscriberRegistrationModel user) throws AddressBookException {
		if(user!=null) {
			if(user.getPassword().equals(user.getConfirmPassword())) {
				user.setPassword(encoder.encode(user.getPassword()));
				subRepo.save(EMParser.parse(user));
			}else {
				throw new AddressBookException("Password do not match");
			}
		}
	}
}
