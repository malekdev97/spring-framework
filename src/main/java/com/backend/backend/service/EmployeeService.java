package com.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.backend.model.Employee;
import com.backend.backend.repository.EmployeeRepository;


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
}
