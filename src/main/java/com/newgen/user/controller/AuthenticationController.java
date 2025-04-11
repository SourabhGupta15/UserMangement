package com.newgen.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newgen.user.dto.*;
import com.newgen.user.model.User;
import com.newgen.user.services.AuthenticationService;
import com.newgen.user.services.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> registerUser(@RequestBody RegisterUserDto inputUser) {
		User registereduser = authenticationService.signup(inputUser);
		return ResponseEntity.ok(registereduser);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUser) {
		
		User authenticateUser = authenticationService.authenticate(loginUser);
		
		String jwtToken = jwtService.generateToken(authenticateUser);
		
		LoginResponse loginResp = new LoginResponse();
		loginResp.setToken(jwtToken);
		loginResp.setExpiresIn(jwtService.getExpirationTime());
		
		return ResponseEntity.ok(loginResp);
	}
}
