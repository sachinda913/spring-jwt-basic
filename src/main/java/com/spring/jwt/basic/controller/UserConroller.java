package com.spring.jwt.basic.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jwt.basic.entity.Student;
import com.spring.jwt.basic.entity.UserProvider;
import com.spring.jwt.basic.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserConroller {
	
	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserConroller.class);
		
	private List<Student> students = new ArrayList<>(List.of(
			new Student(1,"Sachin",24),
			new Student(1,"SS",2)));
	
	@GetMapping("/get")
	public List<Student> hello(HttpServletRequest httpServlet) {
		return students;
	}
	
	@PostMapping("/register")
	public UserProvider registerUser(@RequestBody UserProvider userProvider) {
			return userService.registerUser(userProvider);					
	}
	
	@GetMapping("/csrf")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
		
	}
	
	@GetMapping("/sessionId")
	public String sessionId(HttpServletRequest httpServlet) {
		return httpServlet.getSession().getId();
	}
	
	@PostMapping("/login")
	public String login(@RequestBody UserProvider userProvider) {
		return userService.loginVerify(userProvider);
		
	}
 

}
