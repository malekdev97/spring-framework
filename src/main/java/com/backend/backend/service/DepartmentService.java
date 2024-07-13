package com.backend.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.repository.DepartmentRepository;

@Service
public class DepartmentService {
    
    private DepartmentRepository DepartmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.DepartmentRepository = departmentRepository;
    }
}
