package com.example.lab3.controller;

import com.example.lab3.entity.Student;
import com.example.lab3.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll(@RequestParam(required = false) String keyword) {
        return studentService.search(keyword);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable UUID id) {
        return studentService.findById(id);
    }

    @GetMapping("/code/{code}")
    public Student getByCode(@PathVariable String code) {
        return studentService.findByCode(code);
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String keyword) {
        return studentService.search(keyword);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable UUID id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        studentService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
