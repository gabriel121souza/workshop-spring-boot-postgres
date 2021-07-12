package com.gabrielrodrigues.workshoppostgres.dto;

import java.util.Date;

import com.gabrielrodrigues.workshoppostgres.domain.Post;
import com.gabrielrodrigues.workshoppostgres.domain.User;

public class PostDTO {
	private Long postID;
	private String title;
	private String body;
	private Date date;
	private User author;
	
	public PostDTO() {
		
	}
	public PostDTO(Post post) {
		
		this.postID = post.getPostID();
		this.title = post.getTitle();
		this.body = post.getBody();
		this.date = post.getDate();
		this.author = post.getAuthor();
		
		
	}
	public Long getPostID() {
		return postID;
	}
	public void setPostID(Long postID) {
		this.postID = postID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
	
}
