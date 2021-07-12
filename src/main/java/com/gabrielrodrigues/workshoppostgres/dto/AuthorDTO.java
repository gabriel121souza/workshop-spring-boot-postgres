package com.gabrielrodrigues.workshoppostgres.dto;

import java.io.Serializable;

import com.gabrielrodrigues.workshoppostgres.domain.User;

public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	public AuthorDTO() {
		
	}
	public AuthorDTO(User user) {
	
		this.id = user.getId();
		this.name = user.getName();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
