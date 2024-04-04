package com.backend.backend.repository;

import org.springframework.stereotype.Repository;

import com.backend.backend.entity.License;

import org.springframework.data.jpa.repository.JpaRepository;

// 2- change the name of Args after change Entity class
@Repository
public interface PackageRepository extends JpaRepository<License,Long> {

}
