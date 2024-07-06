package com.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.backend.backend.model.Employee;
import com.backend.backend.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll(){

        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

<<<<<<< HEAD
    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

=======
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee newEmployee) {

        Employee employee = findById(id);
        if(employee != null) {
            employee.setName(newEmployee.getName());
            employee.setEmail(newEmployee.getEmail());
            return saveEmployee(employee);
        }

        return null;

    }

    public Employee deletedEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        
       if(employeeRepository.findById(id) != null) {
            employeeRepository.deleteById(id);
            return employee;
       }

       return null;
    }
>>>>>>> 56cd40a48effb136240c442317523bd207a0984e
}
