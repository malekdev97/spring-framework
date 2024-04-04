package com.backend.backend.service;

import java.util.List;

import com.backend.backend.entity.User;

public interface UserService {
	
	public User createUser(User user);
	public User getUserById(Long id);
	public User updateUser(Long id, User user);
	public User updatePassword(Long id, User user);
	public void deleteUser(Long id);
	public List<User> getAllUsers();

}
