package com.backend.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.backend.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}