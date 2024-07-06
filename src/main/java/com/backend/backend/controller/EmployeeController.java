package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.backend.backend.model.Employee;
import com.backend.backend.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("")
    public ResponseEntity<String> test() {

        return ResponseEntity.ok("working...");
    }

    @GetMapping("employee/all")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("employee/{id}/detail")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {

        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("employee/store")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        Employee newEmployee = employeeService.saveEmployee(employee);

        return ResponseEntity.ok(newEmployee);
    }

    @PutMapping("employee/{id}/update")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@Valid @RequestBody Employee newEmployee) {
        Employee employee = employeeService.updateEmployee(id, newEmployee);
        
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("employee/{id}/delete")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        
        employeeService.deletedEmployeeById(id);

        return ResponseEntity.ok("Deleted successfuly");
    }
}
