package com.backend.backend.controller;

import com.backend.backend.model.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {
    // POJO means Plan Old Java Object

    @GetMapping("/grades{id}")
    public String getGrade(Model model, String id) {
        Grade grade = new Grade("John", "Math", "A");

        model.addAttribute("grade", grade);

        System.out.println(id);

        return "index";
    }
}
