package com.backend.backend.service;

// i didn't Make any changes to this class
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.License;
import com.backend.backend.repository.PackageRepository;

@Service
public class PackageServiceImpl implements PackageService{
	
				// 0- inject Repository in the Service 
				@Autowired
				private PackageRepository packageRepository;

				
				// 1 - Create (C)
				@Override
				public License createPackage(License packageName) {
					return packageRepository.save(packageName);
				}

				// 2- Get : Read (R)
				@Override
				public Optional<License> getPackageById(Long id) {
					return packageRepository.findById(id);
				}
				
				
				// 3- Update (U)
				@Override
				public License updatePackage(Long id, License packageName) {
					License existingSystemPackage = packageRepository.findById(id)
							.orElseThrow(() -> new IllegalArgumentException("Pachage not found"));
					existingSystemPackage.setName(packageName.getName());
					return existingSystemPackage;
				}

				// 4- Delete (D)
				@Override
				public void deletePackage(Long id) {
					packageRepository.deleteById(id);
				}

				// 5- get All : Read All (R)
				@Override
				public List<License> getAllPackages() {
					return packageRepository.findAll();
				}



				
				
				
				

}
