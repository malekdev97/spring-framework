package com.backend.backend.controller;

import java.util.List;
import java.util.Optional;

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

import com.backend.backend.entity.License;
import com.backend.backend.service.LicenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/licenses", method = RequestMethod.GET)
public class LicenseController {
	
	@Autowired
	private LicenseService licenseService;
	
	// CRUD ---------
	
	@GetMapping("/test")
	public String index() {
		return "Greetings from License API!";
	}
	
	
	// New
	@PostMapping("/new")	
	public ResponseEntity<Object> createLicense(@Valid @RequestBody License license) {
		License savedLicense = licenseService.createLicense(license);
		System.out.println(savedLicense);
		return ResponseEntity.ok("License with id " + license.getId() + " successfully added ");
//		return licenseService.createLicense(license);
	}
	
	
	// Get 
	@GetMapping("/get/{id}")
//	public License getLicenseById(@PathVariable("id") Long id) {
	public ResponseEntity<Object> getLicenseById(@PathVariable("id") Long id) {
		License fetchResult = licenseService.getLicenseById(id);
		if(fetchResult == null) {
			return null;
		}
//		String fetchResultInfo = "License Id " + fetchResult.getId() + ", License Name : " + fetchResult.getName() + ", All Info :" + fetchResult;
//		return fetchResult;
		return ResponseEntity.ok(fetchResult);
	}
	
	// Update 
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateLicense(@PathVariable("id") Long id, @Valid @RequestBody License license){
		licenseService.updateLicense(id, license);
		return ResponseEntity.ok("License with Id : " + id +" has been updateed successfully");
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteLicense(@PathVariable("id") Long id) {
		licenseService.deleteLicense(id);
		return ResponseEntity.ok("License with Id : " + id +" has been deleted successfully");
	}
	
	
	// Get All 
	@GetMapping("/get/all")
//	public List<License> getAllLicenses() {
	public ResponseEntity<Object> getAllLicenses() {
		List<License> fetchResult = licenseService.getAllLicenses();
//		return fetchResult;
		return ResponseEntity.ok(fetchResult);
	}

}
