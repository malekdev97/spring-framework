package com.backend.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.backend.backend.exception.DepartmentNotFoundException;
import com.backend.backend.model.Department;
import com.backend.backend.model.Employee;
import com.backend.backend.repository.DepartmentRepository;
import com.backend.backend.repository.EmployeeRepository;


@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

     
    public Employee createEmployee(Long departmentId, Employee employee) {

        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new DepartmentNotFoundException("department with id not found!"));

        employee.setDepartment(department);

        Employee newEmployee = employeeRepository.save(employee);

        return newEmployee;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    
    public List<Employee> getEmployeeByDepartmentId(Long id) {
        List<Employee> employees = employeeRepository.findByDepartmentId(id);

        return employees;
    }



    
    public Employee getEmployeeById(Long employeeId, Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new DepartmentNotFoundException("department does not exist!"));

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new DepartmentNotFoundException("Employee does not exist!"));

        if(!employee.getDepartment().getId().equals(department.getId())) {
            throw new DepartmentNotFoundException("Employee not Found!!");
        }
            else {
                return employee;
        }
    }

    
    public Employee updateEmployee(Long employeeId, Long departmentId, Employee employee) {

        // check if department & employee exist
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new DepartmentNotFoundException("department does not exist!"));
        
        Employee newEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new DepartmentNotFoundException("Employee does not exist!"));

        if(!newEmployee.getDepartment().getId().equals(department.getId())) {
            throw new DepartmentNotFoundException("Employee not Found!!");
        }
            else {
                newEmployee.setName(employee.getName());
                newEmployee.setEmail(employee.getEmail());
                
                Employee updateEmployee = employeeRepository.save(newEmployee); // save method is detecte if the entity is new create if not update

                return updateEmployee;
        }

        

    }

    
    public void deleteEmployee(Long employeeId, Long departmentId) {
        // check if department & employee exist
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new DepartmentNotFoundException("department does not exist!"));
            
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new DepartmentNotFoundException("Employee does not exist!"));

        if(!employee.getDepartment().getId().equals(department.getId())) {
            throw new DepartmentNotFoundException("Employee not Found!!");
        }
            else {
                employeeRepository.delete(employee);
        }
    }

}
