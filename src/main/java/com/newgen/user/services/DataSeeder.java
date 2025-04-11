package com.newgen.user.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.newgen.user.model.User;
import com.newgen.user.model.UserRepository;

@Component
public class DataSeeder implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args ) throws Exception {
//		
//		//Check if data exists? if not create some users
//		if(userRepository.count() < 5) {
//			
//			userRepository.saveAll(List.of(
//					new User(null, "John CMD"),
//					new User(null, "Sarrah CMD")
//					));
//			System.out.println("Data initialised");
//		}
	}
}
