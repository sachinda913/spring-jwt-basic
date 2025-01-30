package com.spring.jwt.basic.repository;

import org.springframework.stereotype.Service;

import com.spring.jwt.basic.entity.UserProvider;

@Service
public interface UserProviderRepository {

	UserProvider save(UserProvider userProvider);
	
	UserProvider findById(int id);

}
