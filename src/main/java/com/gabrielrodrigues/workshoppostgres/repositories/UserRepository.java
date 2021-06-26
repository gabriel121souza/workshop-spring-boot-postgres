package com.gabrielrodrigues.workshoppostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielrodrigues.workshoppostgres.domain.User;

public interface UserRepository extends JpaRepository<User, String>{

}
