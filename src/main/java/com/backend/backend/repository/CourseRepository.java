package com.backend.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.backend.entity.Course;


public interface CourseRepository extends CrudRepository<Course, Long> {

}