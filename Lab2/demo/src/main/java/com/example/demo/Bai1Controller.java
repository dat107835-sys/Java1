package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Bài 1: Tạo Spring Boot REST API đơn giản (Hello API)
 */
@RestController
@RequestMapping("/api")
public class Bai1Controller {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }
}
