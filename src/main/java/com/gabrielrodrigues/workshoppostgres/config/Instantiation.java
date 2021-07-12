package com.gabrielrodrigues.workshoppostgres.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gabrielrodrigues.workshoppostgres.domain.Post;
import com.gabrielrodrigues.workshoppostgres.domain.User;
import com.gabrielrodrigues.workshoppostgres.repositories.PostRepository;
import com.gabrielrodrigues.workshoppostgres.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User gabriel = new User(null, "Gabriel", "gabriel121souza@gmail.com");
		User daniel = new User(null, "Daniel", "daniel@gmail.com");
		User juliana = new User(null, "Juliana", "juliana@gmail.com");
		userRepository.saveAll(Arrays.asList(gabriel, daniel, juliana));

		Post post1 = new Post(null, "partiu viagem", sdf.parse("21/03/2018"), "vou viajar para sao paulo beijos", gabriel);
		Post post2 = new Post(null, "Bom dia", sdf.parse("23/03/2018"), "feliz hoje", daniel);
		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
