package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Bài 4A: Trả về JSON Object
 */
@RestController
@RequestMapping("/api")
public class Bai4AController {

    @GetMapping("/students")
    public Student getStudent() {
        return new Student(1, "Nguyễn Văn A", 20);
    }
}
