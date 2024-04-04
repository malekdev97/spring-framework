package com.backend.backend.service;

import java.util.List;
import java.util.Optional;

import com.backend.backend.entity.License;

public interface PackageService {
	// 2- change the return Type of this method after change Entity Class + Change Args Return Type + change Args Name 
	public License createPackage(License packagee);
	// 3- change the return Type of this method after change Entity Class 
	public Optional<License> getPackageById(Long id);
	// 4- change the return Type of this method after change Entity Class + Change Args Return Type + change Args Name 
	public License updatePackage(Long id, License packageName);
	// 2- change the return Type of this method after change Entity Class + Change Args Return Type + change Args Name 
	public void deletePackage(Long id);
	// 2- change the return Type of this method after change Entity Class 
	public List<License> getAllPackages();

}
