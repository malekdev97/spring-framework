package com.backend.backend.service;

import java.util.List;
import java.util.Optional;

import com.backend.backend.entity.License;

public interface LicenseService {
	
	public License createLicense(License license);
	public License getLicenseById(Long id);
	public License updateLicense(Long id, License license);
	public void deleteLicense(Long id);
	public List<License> getAllLicenses();

}
