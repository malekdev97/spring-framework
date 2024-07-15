package com.backend.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.backend.model.Department;
import com.backend.backend.model.Product;
import com.backend.backend.repository.DepartmentRepository;
import com.backend.backend.exception.DepartmentNotFoundException;
import com.backend.backend.exception.ProductNotFoundException;

import java.util.List;

@Service
public class DepartmentService {
    
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findDepartmentById(Long id) {
        Department dep = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Product not found!"));
        return dep;
    }

    public Department updateDepartment(Long id, Department newDepartment) {

        Department dep = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found!"));

        if(!dep.equals(null)) {
            dep.setName(newDepartment.getName());

            return dep;
        }

       return null;
    }

    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found!"));
        departmentRepository.delete(department);
    }
}
