package com.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backend.entity.Industry;

@Repository
public interface IndustryRepository extends JpaRepository<Industry,Long>{

}
