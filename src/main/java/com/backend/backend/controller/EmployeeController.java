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
        List<Employee> employees = employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("employee/{id}/detail")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {

        Employee employee = employeeService.getEmployeeById(id, id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("department/{depid}/employee/create")
    public ResponseEntity<Employee> saveEmployee(@PathVariable(name = "depid") Long depId, @Valid @RequestBody Employee employee) {
        Employee newEmployee = employeeService.createEmployee(depId, employee);

        return ResponseEntity.ok(newEmployee);
    }

    @PutMapping("department/{depid}/employee/{empid}/update")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "empId") Long empId, @PathVariable(name = "depId") Long depId ,@Valid @RequestBody Employee newEmployee) {
        Employee employee = employeeService.updateEmployee(empId, depId, newEmployee);
        
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("department/{did}/employee/{eid}/delete")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long depId,@PathVariable Long empId) {
        
        employeeService.deleteEmployee(empId, depId);

        return ResponseEntity.ok("Deleted successfuly");
    }
}
