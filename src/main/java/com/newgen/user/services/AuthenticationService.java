package com.newgen.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.newgen.user.dto.LoginUserDto;
import com.newgen.user.dto.RegisterUserDto;
import com.newgen.user.model.User;
import com.newgen.user.model.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public User signup(RegisterUserDto inputUser) {
		User user = new User();
		user.setFullName(inputUser.getFullName());
		user.setEmail(inputUser.getEmail());
		user.setPassword(passwordEncoder.encode(inputUser.getPassword()));
		
		userRepository.save(user);
		return user;
	}
	
	public User authenticate(LoginUserDto loginUser) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));
		return userRepository.findByEmail(loginUser.getEmail()).orElseThrow();
	}
}
