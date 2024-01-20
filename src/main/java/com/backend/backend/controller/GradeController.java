package com.backend.backend.controller;

import com.backend.backend.model.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    // POJO means Plan Old Java Object

    @GetMapping("/grades")
    public String getGrade(Model model) {

        model.addAttribute("grades", studentGrades);

        return "grades";
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String name) {
        // System.out.println(name);

        Grade grade;
        if(getGradeIndex(name) == -1) {
            grade = new Grade();
        } else {
            grade = studentGrades.get(getGradeIndex(name));
        }
        model.addAttribute("grade", grade);

        return "form";
    }

    @PostMapping("/handlesubmit")
    public String submitForm(Grade grade) {
        int index = getGradeIndex(grade.getName());

        if(index == -1) {
            studentGrades.add(grade);
        } else {
            studentGrades.set(index, grade);
        }
        //System.out.println(grade.toString());
        studentGrades.add(grade);

        return "redirect:/grades";
    }

    public Integer getGradeIndex(String name) {
        for(int i = 0; i < studentGrades.size(); i++) {
            if(studentGrades.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
