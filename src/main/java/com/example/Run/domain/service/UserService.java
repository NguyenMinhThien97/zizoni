package com.example.Run.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.Run.domain.entity.User;

public interface UserService {
	public List<User> getAllUser();
	public User createUser(User user);
	public User Update(User user);
	public void deleteUserById(long id);
	public Optional<User> findById(long id);
}
