package com.spring.jwt.basic.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.jwt.basic.crudRepository.UserProviderCrudRepo;
import com.spring.jwt.basic.entity.UserProvider;
import com.spring.jwt.basic.repository.UserProviderRepository;

@Repository
public class UserProviderRepoImpl implements UserProviderRepository{

	
	@Autowired
	UserProviderCrudRepo userProviderCrudRepo;
	
	public UserProvider findUserByUsername(String username) {
		return userProviderCrudRepo.findUserByUsername(username);
	}

	@Override
	public UserProvider save(UserProvider userProvider) {
		return userProviderCrudRepo.save(userProvider);
	}

}
