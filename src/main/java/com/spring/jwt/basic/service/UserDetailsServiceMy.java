package com.spring.jwt.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.jwt.basic.entity.UserPrincipal;
import com.spring.jwt.basic.entity.UserProvider;
import com.spring.jwt.basic.repositoryImpl.UserProviderRepoImpl;

@Service
public class UserDetailsServiceMy implements UserDetailsService{

	@Autowired
	UserProviderRepoImpl userProviderRepoImpl;
	
	// Find the User from the user_name 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserProvider userProvider = userProviderRepoImpl.findUserByUsername(username);
		
		if(userProvider == null) {
			throw new UsernameNotFoundException("User Not Found");
		}		
		return new UserPrincipal(userProvider);
	}

}
