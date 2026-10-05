package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * Bài 4B: Trả về danh sách (List) các JSON Object
 */
@RestController
@RequestMapping("/api")
public class Bai4BController {

    @GetMapping("/studentall")
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "A", 20));
        list.add(new Student(2, "B", 21));
        return list;
    }
}
