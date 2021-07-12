package com.gabrielrodrigues.workshoppostgres.resourcers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabrielrodrigues.workshoppostgres.domain.Post;
import com.gabrielrodrigues.workshoppostgres.domain.User;
import com.gabrielrodrigues.workshoppostgres.dto.PostDTO;
import com.gabrielrodrigues.workshoppostgres.dto.UserDTO;
import com.gabrielrodrigues.workshoppostgres.services.PostService;


@RestController
@RequestMapping(value="/posts")
public class PostResource {
	@Autowired
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll(){
		List<Post> list = postService.findAll();
		List<PostDTO> listDTO = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable Long id)  {
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(new PostDTO(post));
		}
	
	@PostMapping
	public ResponseEntity<PostDTO> createdUser(@RequestBody PostDTO postDTO){
		Post post = postService.insert(postDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getPostID()).toUri();
		return ResponseEntity.created(uri).build();
	}
	/*
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "/{userId}")
	public ResponseEntity<UserDTO> update(@PathVariable Long userId, @RequestBody UserDTO userDTO){
		userService.update(userId, userDTO);
		return ResponseEntity.ok().body(userDTO);
	}
	*/
}
	

