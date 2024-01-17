package com.backend.backend.controller;

import com.backend.backend.model.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeController {

    List<Grade> studentGrades = Arrays.asList(
            new Grade("John", "Math", "A"),
            new Grade("Smith", "English", "B"),
            new Grade("Sam", "Science", "C"),
            new Grade("Jack", "History", "D"),
            new Grade("Anderson", "Geography", "E")
    );

    // POJO means Plan Old Java Object

    @GetMapping("/grades")
    public String getGrade(Model model) {

        model.addAttribute("grades", studentGrades);

        return "grades";
    }
}
