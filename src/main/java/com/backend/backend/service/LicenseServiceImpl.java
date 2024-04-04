package com.backend.backend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.License;
import com.backend.backend.repository.LicenseRepository;

@Service
public class LicenseServiceImpl implements LicenseService{
	
	// 1- inject Repository in the Service 
	@Autowired
	private LicenseRepository licenseRepository;
	
	
	// CRUD
	@Override
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}

	@Override
	public License getLicenseById(Long id) {
		Optional<License> license = licenseRepository.findById(id);
		if(!license.isPresent()) {
			System.out.println("license with id " + id + " doesn't Exist ");
			return null;
		}
		System.out.println("license with id " + id + " is : " + license.toString());
		return license.get();
//		if(license.get().isDeleted()) {
//			System.out.println("license with id " + id + " is deleted ");
//			return null;
//		}
		//return licenseRepository.findById(id);
	}

	@Override
	public License updateLicense(Long id, License license) {
		License licenseFromDB = licenseRepository.findById(id).get();
		
		// New Value :
		String licenseName = license.getName();
		String licenseDescription = license.getDescription();
		
		// Print The Checks
		System.out.println(Objects.nonNull(licenseName));
		System.out.println("".equalsIgnoreCase(licenseName));
		System.out.println(!"".equalsIgnoreCase(licenseName));
		
		// Null and Blank checks of the new values 
		if(Objects.nonNull(licenseName) && !"".equalsIgnoreCase(licenseName)) {
			licenseFromDB.setName(licenseName);
		}
		if(Objects.nonNull(licenseDescription) && !"".equalsIgnoreCase(licenseDescription)) {
			licenseFromDB.setDescription(licenseDescription);
		}
		
		return licenseRepository.save(licenseFromDB);
	}

	
	@Override
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id); }
//		License license = licenseRepository.findById(id).get();
//
//			license.setDeleted(true);
//
//			license.setName("loooool");
//			System.out.println("license with id : " + id + " has been deleted");
			
//			if(!license.isPresent()) {
//				System.out.println("license with id : " + id + " Not Fuond");
//				return null;
//			}
			
//			if(license != null) {
//				return null;
//			}		
//		return license;
	
	
	@Override
	public List<License> getAllLicenses() {
		return licenseRepository.findAll();}
	
	

}
