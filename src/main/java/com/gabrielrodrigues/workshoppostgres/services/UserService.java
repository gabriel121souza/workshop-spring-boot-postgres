package com.gabrielrodrigues.workshoppostgres.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrodrigues.workshoppostgres.domain.User;
import com.gabrielrodrigues.workshoppostgres.repositories.UserRepository;
import com.gabrielrodrigues.workshoppostgres.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return  userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("usuario nao encontrado  = " + id));
	}
}