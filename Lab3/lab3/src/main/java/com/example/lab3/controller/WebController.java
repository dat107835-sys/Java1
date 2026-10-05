package com.example.lab3.controller;

import com.example.lab3.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private final StudentService studentService;

    public WebController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping({"/", "/students"})
    public String students(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }
}
