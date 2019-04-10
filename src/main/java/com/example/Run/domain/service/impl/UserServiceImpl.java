package com.example.Run.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Run.domain.entity.User;
import com.example.Run.domain.repository.UserRepository;
import com.example.Run.domain.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User Update(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public Optional<User> findById(long id) {
		
		return userRepository.findById(id);
	}
	
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
}
