package com.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.Employee;
import com.backend.backend.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll(){

        return employeeRepository.findAll();
    }
}
