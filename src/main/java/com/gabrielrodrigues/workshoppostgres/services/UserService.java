package com.gabrielrodrigues.workshoppostgres.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrodrigues.workshoppostgres.domain.User;
import com.gabrielrodrigues.workshoppostgres.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return  userRepository.findAll();
	}
	
	
}
