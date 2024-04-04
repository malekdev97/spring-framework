package com.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backend.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long>{

}
