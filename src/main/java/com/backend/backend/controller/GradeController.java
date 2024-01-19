package com.backend.backend.controller;

import com.backend.backend.model.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/form")
    public String getForm(Model model) {

        model.addAttribute("grade", new Grade());

        return "form";
    }

    @PostMapping("/handlesubmit")
    public String submitForm(Grade grade) {

        //System.out.println(grade.toString());
        studentGrades.add(grade);

        return "redirect:/grades";
    }
}
