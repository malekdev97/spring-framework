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
import com.backend.backend.model.Department;
import java.util.List;
import com.backend.backend.service.DepartmentService;

@RestController
@RequestMapping("api/v1/")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {

        this.departmentService = departmentService;
    }
    
    @GetMapping("department/all")
    public ResponseEntity<List<Department>> getAllDepartment(){
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("department/{id}/detail")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department department = departmentService.findDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @PostMapping("department/create")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

    @PutMapping("department/{id}/update")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {

        return ResponseEntity.ok(departmentService.updateDepartment(id, department));
    }

    @DeleteMapping("department/{id}/delete")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted!");
    }

}
