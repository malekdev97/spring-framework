package com.backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.entity.Branch;
import com.backend.backend.service.BranchService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/branch", method = RequestMethod.GET)
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	
	@GetMapping("/test")
	public String index() {
		return "Greetings from Branch API!";
	}
	
	
	@PostMapping("/new")	
	public ResponseEntity<Object> createBranch(@Valid @RequestBody Branch branch) {
		Branch savedBranch = branchService.createBranch(branch);
		System.out.println(savedBranch);
		return ResponseEntity.ok("Branch with id " + branch.getId() + " successfully added ");
	}
	
	
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getBranchById(@PathVariable("id") Long id) {
		Branch fetchResult = branchService.getBranchById(id);
		if(fetchResult == null) {
			return null;
		}
		return ResponseEntity.ok(fetchResult);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateBranch(@PathVariable("id") Long id, @Valid @RequestBody Branch branch){
		branchService.updateBranch(id, branch);
		return ResponseEntity.ok("Branch with Id : " + id +" has been updateed successfully");
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteBranch(@PathVariable("id") Long id) {
		branchService.deleteBranch(id);
		return ResponseEntity.ok("Branch with Id : " + id +" has been deleted successfully");
	}
	
	
	@GetMapping("/get/all")
	public ResponseEntity<Object> getAllBranchs() {
		List<Branch> fetchResult = branchService.getAllBranchs();
		return ResponseEntity.ok(fetchResult);
	}
	
	
	
	
	
		
		
	
	

}
