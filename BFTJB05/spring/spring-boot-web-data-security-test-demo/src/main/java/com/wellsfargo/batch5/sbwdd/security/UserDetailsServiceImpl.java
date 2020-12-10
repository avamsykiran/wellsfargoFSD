package com.wellsfargo.batch5.sbwdd.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch5.sbwdd.entity.LibraryUser;
import com.wellsfargo.batch5.sbwdd.exception.LibraryException;
import com.wellsfargo.batch5.sbwdd.model.RegisterLibraryMemberModel;
import com.wellsfargo.batch5.sbwdd.repo.LibraryUserRepo;
import com.wellsfargo.batch5.sbwdd.util.EMParser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private LibraryUserRepo userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = null;
		
		if(!userRepo.existsByUserName(username)) {
			throw new UsernameNotFoundException("Invalid user credentials!");
		}	
		
		LibraryUser libUser = userRepo.findByUserName(username);
		
		user = (UserDetails) new User(libUser.getUserName(), libUser.getPassword(), 
					Collections.singletonList(new SimpleGrantedAuthority(libUser.getRole()))
				);
		
		return user;
	}

	public void registerMember(RegisterLibraryMemberModel libMember) throws LibraryException {
		if(libMember!=null) {
			if(libMember.getPassword().equals(libMember.getConfirmPassword())) {
				libMember.setPassword(encoder.encode(libMember.getPassword()));
				userRepo.save(EMParser.parse(libMember));
			}else {
				throw new LibraryException("Password do not match");
			}
		}		
	}
}
