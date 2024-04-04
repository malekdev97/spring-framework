package com.backend.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.User;
import com.backend.backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	// 1- inject Repository in the Service 
	@Autowired
	private UserRepository userRepository;

	
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updatePassword(Long id, User user) {
		User userFromDB = userRepository.findById(id).get();
		userFromDB.setPassword(user.getPassword());
		return userRepository.save(userFromDB);
	}

	
	@Override
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			System.out.println("user with id " + id + " doesn't Exist ");
			return null;
		}
		System.out.println("user with id " + id + " is : " + user.toString());
		return user.get();
//		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(Long id, User user) {
		
		User userFromDB = userRepository.findById(id).get();
		
		// New Value :
		String userName = user.getName();
		String userEmail = user.getEmail();
		String userUsername = user.getUsername();
		String userPhone = user.getPhone();
		String userPassword = user.getPassword();
		int userNumberOfEmployees = user.getNumberOfEmployees();
		Date userStartDate = user.getStartDate();
		Date userEndDate = user.getEndDate();

		
		// Print The Checks
		System.out.println(Objects.nonNull(userName));
		System.out.println("".equalsIgnoreCase(userName));
		System.out.println(!"".equalsIgnoreCase(userName));
		
		// Null and Blank checks of the new values 
		if(Objects.nonNull(userName) && !"".equalsIgnoreCase(userName)) {
			userFromDB.setName(userName);
		}
		
		if(Objects.nonNull(userEmail) && !"".equalsIgnoreCase(userEmail)) {
			userFromDB.setEmail(userEmail);
		}
		
		if(Objects.nonNull(userUsername) && !"".equalsIgnoreCase(userUsername)) {
			userFromDB.setUsername(userUsername);
		}
		
		if(Objects.nonNull(userPhone) && !"".equalsIgnoreCase(userPhone)) {
			userFromDB.setPhone(userPhone);
		}
		
		if(Objects.nonNull(userPassword) && !"".equalsIgnoreCase(userPassword)) {
			userFromDB.setPassword(userPassword);
		}
		
		// Chick this ****
		if(Objects.nonNull(userNumberOfEmployees)) {
			userFromDB.setNumberOfEmployees(userNumberOfEmployees);
		}
		
		if(Objects.nonNull(userStartDate)) {
			userFromDB.setStartDate(userStartDate);
		}
		
		if(Objects.nonNull(userEndDate)) {
			userFromDB.setEndDate(userEndDate);
		}
		
		
		return userRepository.save(userFromDB);

	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	

}
