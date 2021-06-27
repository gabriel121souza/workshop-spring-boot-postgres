package com.gabrielrodrigues.workshoppostgres.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gabrielrodrigues.workshoppostgres.domain.User;
import com.gabrielrodrigues.workshoppostgres.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User gabriel = new User(null, "Gabriel", "gabriel121souza@gmail.com");
		User daniel = new User(null, "Daniel", "daniel@gmail.com");
		User juliana = new User(null, "Juliana", "juliana@gmail.com");
		
		userRepository.saveAll(Arrays.asList(gabriel, daniel, juliana));
	}

}
