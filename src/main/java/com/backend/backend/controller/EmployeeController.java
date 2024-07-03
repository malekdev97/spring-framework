package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.backend.backend.entity.Employee;
import com.backend.backend.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("/")
    public ResponseEntity test() {

        return ResponseEntity.ok("working...");
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();

        return ResponseEntity.ok(employees);
    }
}
