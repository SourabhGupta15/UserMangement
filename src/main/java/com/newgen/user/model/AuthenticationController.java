package com.newgen.user.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newgen.user.dto.RegisterUserDto;
import com.newgen.user.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> registerUser(@RequestBody RegisterUserDto inputUser) {
		User registereduser = authenticationService.signup(inputUser);
		
		return ResponseEntity.ok(registereduser);
	}
}
