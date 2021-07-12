package com.gabrielrodrigues.workshoppostgres.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrodrigues.workshoppostgres.domain.Post;
import com.gabrielrodrigues.workshoppostgres.domain.User;
import com.gabrielrodrigues.workshoppostgres.dto.PostDTO;
import com.gabrielrodrigues.workshoppostgres.repositories.PostRepository;
import com.gabrielrodrigues.workshoppostgres.repositories.UserRepository;
import com.gabrielrodrigues.workshoppostgres.services.exceptions.BadRequestException;
import com.gabrielrodrigues.workshoppostgres.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	public List<Post> findAll(){
		return  postRepository.findAll();
	}

	public Post findById(Long id) {
		return postRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("usuario nao encontrado  = " + id));
	}
	
	public Post insert(PostDTO postDTO) {
		if(postDTO != null) {	
		Post post = new Post();
		User author = new User();
			author = userRepository.findById(postDTO.getAuthor().getId()).get();
			post.setTitle(postDTO.getTitle());
			post.setBody(postDTO.getBody());
			post.setDate(new Date());
			post.setAuthor(author);
			if(post!=null) {
			postRepository.save(post);
			return post;
			}
		}
		throw new BadRequestException("nao foi possivel inserir o usuario");
	}
	/*
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
	*/
}