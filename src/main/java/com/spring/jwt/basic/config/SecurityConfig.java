package com.spring.jwt.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.jwt.basic.filter.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	// Create Custom security and disable default security
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
		return http
				.csrf(csrfCustomizer -> csrfCustomizer.disable())  // disable CSRF 
				.authorizeHttpRequests(request -> request
						.requestMatchers("register" , "login") // -> This Request API don't need authentication
						.permitAll()
						.anyRequest().authenticated()) // All Request are authenticated
				.httpBasic(Customizer.withDefaults()) // for postman enable rest API Access
//				.formLogin(Customizer.withDefaults()) // for Browsers enable rest API Access
				.sessionManagement(session -> 
						session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // Use jwtFilter before execute UsernamePasswordAuthenticationFilter
				.build();
		//sessionManagement give new sessionId (for the browser new Session Id always generating and can't logging | comment formLogin and it will work.
				
	}
	
	// Create custom AuthenticationProvider and pass passwordEncoder and UserDetailsService.
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // -> no Password Encode
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12)); // After password Encoding
		provider.setUserDetailsService(userDetailsService);		
		return provider;		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
		
	}
	

}
