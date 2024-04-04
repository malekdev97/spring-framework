package com.backend.backend.service;

import java.util.List;
import com.backend.backend.entity.Branch;


public interface BranchService {
	
	public Branch createBranch(Branch branch);
	public Branch getBranchById(Long id);
	public Branch updateBranch(Long id, Branch branch);
	public void deleteBranch(Long id);
	public List<Branch> getAllBranchs();

}
