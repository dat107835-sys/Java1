package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Bài 3: API với Request Param (Query String)
 */
@RestController
@RequestMapping("/api")
public class Bai3Controller {

    @GetMapping("/student")
    public String greet(@RequestParam String name) {
        return "Xin chào " + name;
    }

    @GetMapping("/searchstudent")
    public String searchStudent(@RequestParam String name, 
                                 @RequestParam(defaultValue = "1") int age) {
        return "Tên=" + name + ", tuổi=" + age;
    }
}
