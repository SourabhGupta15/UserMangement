package com.newgen.user.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.user.model.User;
import com.newgen.user.model.UserRepository;

@Service
public class UserJPAService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUserByID(Integer id) {
		return userRepository.findById(id);
	}
	
//	public User createUser(User user) {
//		return userRepository.save(user);
//	}
//	
//	public void deleteUser(Integer id) {
//		userRepository.deleteById(id);
//	}
}
