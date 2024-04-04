package com.backend.backend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.Branch;
import com.backend.backend.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService{
	
	// 1- inject Repository in the Service 
	@Autowired
	private BranchRepository branchRepository;
	

	@Override
	public Branch createBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	@Override
	public Branch getBranchById(Long id) {
		
		Optional<Branch> branch = branchRepository.findById(id);
		if(!branch.isPresent()) {
			System.out.println("Branch with id " + id + " doesn't Exist ");
			return null;
		}
		System.out.println("Branch with id " + id + " is : " + branch.toString());
		return branch.get();
//		return branchRepository.findById(id);
	}

	
	@Override
	public Branch updateBranch(Long id, Branch branch) {
		
		Branch branchFromDB = branchRepository.findById(id).get();
		
		// New Value :
		String branchName = branch.getName();
		String branchCity = branch.getCity();
		
		// Print The Checks
		System.out.println(Objects.nonNull(branchName));
		System.out.println("".equalsIgnoreCase(branchName));
		System.out.println(!"".equalsIgnoreCase(branchName));
		
		// Null and Blank checks of the new values 
		if(Objects.nonNull(branchName) && !"".equalsIgnoreCase(branchName)) {
			branchFromDB.setName(branchName);
		}
		if(Objects.nonNull(branchCity) && !"".equalsIgnoreCase(branchCity)) {
			branchFromDB.setCity(branchCity);
		}
		
		return branchRepository.save(branchFromDB);
		
		
//		Branch existingBranch = branchRepository.findById(id)
//				.orElseThrow(() -> new IllegalArgumentException("Branch not found"));
//		// anonymous function or a lambda function
//					existingBranch.setName(branch.getName());
//					existingBranch.setCity(branch.getCity());
//					existingBranch.setDeleted(branch.isDeleted());
//				return existingBranch;
	}

	
	@Override
	public void deleteBranch(Long id) {
		branchRepository.deleteById(id);
	}

	@Override
	public List<Branch> getAllBranchs() {
		return branchRepository.findAll();
	}

}
