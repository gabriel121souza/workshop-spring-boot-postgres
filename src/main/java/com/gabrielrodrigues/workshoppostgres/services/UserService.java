package com.gabrielrodrigues.workshoppostgres.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrodrigues.workshoppostgres.domain.User;
import com.gabrielrodrigues.workshoppostgres.dto.UserDTO;
import com.gabrielrodrigues.workshoppostgres.repositories.UserRepository;
import com.gabrielrodrigues.workshoppostgres.services.exceptions.BadRequestException;
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
	
	public User insert(UserDTO userDTO) {
		if(userDTO != null) {	
		User user = new User();
			user.setName(userDTO.getName());
			user.setEmail(userDTO.getEmail());
			if(user!=null) {
			userRepository.save(user);
			return user;
			}
		}
		throw new BadRequestException("nao foi possivel inserir o usuario");
	}
	
	public void delete(Long id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(Long userId, UserDTO userDTO) {
		User user = findById(userId);
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		try {
		return userRepository.save(user);
		}catch(BadRequestException e) {
			throw new BadRequestException("não foi possivel alterar o usuario");
		}
	}
}