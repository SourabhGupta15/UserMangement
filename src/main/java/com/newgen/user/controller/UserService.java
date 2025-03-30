package com.newgen.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.newgen.user.model.User;

@Component
public class UserService {

	private static List<User> userList = new ArrayList<User>();
	static {
		userList.add(new User(100, "Bob"));
		userList.add(new User(101, "Alex"));
		userList.add(new User(102, "Sarah"));
	}

	public List<User> findAll() {
		return userList;
	}

	public static Optional<User> getUserByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
