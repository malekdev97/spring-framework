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

import com.backend.backend.entity.Industry;
import com.backend.backend.service.IndustryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/industry", method = RequestMethod.GET)
public class IndustryController {
	
	@Autowired
	private IndustryService industryService;
	
	
	@GetMapping("/test")
	public String index() {
		return "Greetings from Industry API!";
	}
	
	
	// New Industry
	@PostMapping("/new")	
	public ResponseEntity<Object> createIndustry(@Valid @RequestBody Industry industry) {
		Industry savedIndustry = industryService.createIndustry(industry);
		System.out.println(savedIndustry);
		return ResponseEntity.ok("Industry with id " + industry.getId() + " successfully added ");		
	}
	
	
	// Get Industry
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getIndustryById(@PathVariable("id") Long id) {
		Industry fetchResult = industryService.getIndustryById(id);
		if(fetchResult == null) {
			return null;
		}
		String fetchResultInfo = "Industry Id " + fetchResult.getId() + ", Industry Name : " + fetchResult.getName() + ", All Info :" + fetchResult;
		return ResponseEntity.ok(fetchResult);
	}
	
	
	// Update Industry
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateIndustry(@PathVariable("id") Long id, @Valid @RequestBody Industry industry){
		industryService.updateIndustry(id, industry);
		return ResponseEntity.ok("Industry with Id : " + id +" has been updateed successfully");
	}
	
	
	// Delete Industry
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteIndustry(@PathVariable("id") Long id) {
		industryService.deleteIndustry(id);	
		return ResponseEntity.ok("Industry with Id : " + id +" has been deleted successfully");	
	}
	
	// Get All 
	@GetMapping("/get/all")
	public ResponseEntity<Object> getAllIndustries() {
		List<Industry> fetchResult = industryService.getAllIndustries();
		return ResponseEntity.ok(fetchResult);
	}
	
	
	
	
	
	

}
