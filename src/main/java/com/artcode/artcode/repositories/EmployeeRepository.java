package com.artcode.artcode.repositories;

import com.artcode.artcode.models.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
