package com.acadeu.web.app.services;


import com.acadeu.web.app.exception.UsernameOrIdNotFound;

import java.util.Optional;

import com.acadeu.web.app.entity.User;

public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws UsernameOrIdNotFound;
	
	
}
