package com.spring.jwt.basic.crudRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jwt.basic.entity.UserProvider;

import jakarta.transaction.Transactional;

@Transactional
public interface UserProviderCrudRepo extends JpaRepository<UserProvider, Integer>{

	UserProvider findUserByUsername(String username);

}
