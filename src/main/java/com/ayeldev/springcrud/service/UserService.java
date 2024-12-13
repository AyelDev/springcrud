package com.ayeldev.springcrud.service;

import java.util.List;

import com.ayeldev.springcrud.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	void saveUser(User user);
	
	User getUserId(long id);
	
	void deleteUserById(long id);
	
}
