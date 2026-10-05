package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Schoolmanager REST API Controller
 */
@RestController
@RequestMapping("/api")
public class SchoolmanagerApplication {

    // API lấy học sinh kèm header Authorization
    @GetMapping("/getstudent")
    public String getStudents(
            @RequestHeader(value = "Authorization", defaultValue = "Bearer abc123") String inputstring) {
        return "Authorization = " + inputstring;
    }
}
