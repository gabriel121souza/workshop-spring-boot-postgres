package com.gabrielrodrigues.workshoppostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielrodrigues.workshoppostgres.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
