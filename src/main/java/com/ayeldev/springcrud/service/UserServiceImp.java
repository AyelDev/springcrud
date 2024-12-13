package com.ayeldev.springcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayeldev.springcrud.model.User;
import com.ayeldev.springcrud.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userRepository.save(user);
	}

	@Override
	public User getUserId(long id) {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(id);
		User user = optional.get();
		if (optional.isEmpty())
			throw new RuntimeException(" User not found for id :: " + id);

		return user;
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
	}

}
