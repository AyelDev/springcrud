package com.ayeldev.springcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayeldev.springcrud.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
