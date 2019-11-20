package com.rparenato.cursoSpringBootMongoDB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rparenato.cursoSpringBootMongoDB.domain.User;
import com.rparenato.cursoSpringBootMongoDB.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

}
