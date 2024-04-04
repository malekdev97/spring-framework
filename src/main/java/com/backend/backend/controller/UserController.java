package com.backend.backend.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.backend.backend.entity.User;
import com.backend.backend.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
	
	// 0- inject Service in the Service 
	@Autowired
	private UserService userService;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	// Test GET Requests .. 
	@GetMapping("/test")
	public String index() {
		return "Greetings from User API!";
	}
	
	
	
	// 1 : create user
	@PostMapping("/new")	
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.createUser(user);
		System.out.println(savedUser);
		return ResponseEntity.ok("User with id " + user.getId() + " successfully added ");
//		return userService.createUser(user);
	}
	
	

//	@PostMapping("/new")	
//	public ResponseEntity<Object> createUser(@RequestBody User user) {
//		User savedUser = userService.createUser(user);
//		return ResponseEntity.ok("Service Status is :  " + savedUser.toString());
//	}

	// 2 : get user
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) {
		User fetchResult = userService.getUserById(id);
		if(fetchResult == null) {
			return null;
		}
		return ResponseEntity.ok(fetchResult);
//		return userService.getUserById(id);
	}
	
	// 3 : update user
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") Long id, @Valid @RequestBody User user) {
		userService.updateUser(id, user);
		return ResponseEntity.ok("User with Id : " + id + " has been updateed successfully");
//		return userService.updateUser(userId,updatedUser);
	}

	// 4 : delete user
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("User with Id : " + id +" has been deleted successfully");
	}

	// 5 : get all users
	@GetMapping("/get/all")
	public ResponseEntity<Object> getAllUsers() {
		List<User> fetchResult = userService.getAllUsers();
		return ResponseEntity.ok(fetchResult);
	}
	

}
