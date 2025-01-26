package com.spring.jwt.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.jwt.basic.entity.UserProvider;
import com.spring.jwt.basic.repository.UserProviderRepository;

@Service
public class UserService {
	
	@Autowired
	UserProviderRepository userProviderRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	private BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder(12);

	public UserProvider registerUser(UserProvider userProvider) {
		userProvider.setPassword(bEncoder.encode(userProvider.getPassword()));		
		return userProviderRepository.save(userProvider);
		
	}

	public String loginVerify(UserProvider userProvider) {
		Authentication authentication = 
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userProvider.getUsername(), userProvider.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(userProvider.getUsername());
		}else {
			return "Fail";
			
		}
	}

}
