package com.backend.backend.service;

import java.util.List;
import java.util.Set;

import com.backend.backend.entity.Course;
import com.backend.backend.entity.Student;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);    
    Course addStudentToCourse(Long studentId, Long courseId);
    List<Course> getCourses();
    Set<Student> getEnrolledStudents(Long id);
}