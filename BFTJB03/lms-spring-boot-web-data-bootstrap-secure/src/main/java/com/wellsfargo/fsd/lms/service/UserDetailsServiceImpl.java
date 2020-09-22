package com.wellsfargo.fsd.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.lms.dao.LMSUserRepo;
import com.wellsfargo.fsd.lms.entity.LMSUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PasswordEncoder pEnc;
	
	@Autowired
	private LMSUserRepo userRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDetails userDetails;

		LMSUser user = userRepo.findByUserName(userName);
		
		if(user==null) {
			throw new UsernameNotFoundException("No Such User Found  ");
		}
		
		List<GrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
			
		userDetails = (UserDetails) new User(
				user.getUserName(),
				user.getEncodedPassword(),
				authorities);
		
		
		return userDetails;
	}

	public LMSUser save(LMSUser user) {
		user.setEncodedPassword(pEnc.encode(user.getPassword()));
		return userRepo.save(user);
	} 
}