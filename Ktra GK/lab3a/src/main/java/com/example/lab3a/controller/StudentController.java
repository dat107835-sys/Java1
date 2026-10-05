package com.example.lab3a.controller;

import java.util.List;
import java.util.UUID;

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

import com.example.lab3a.entity.Student;
import com.example.lab3a.service.StudentService;

@RestController
@RequestMapping({"/api/students", "/students"})
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> listStudents(@RequestParam(required = false) String keyword) {
		return studentService.search(keyword);
	}

	@GetMapping("/search")
	public List<Student> searchStudents(@RequestParam String keyword) {
		return studentService.search(keyword);
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable UUID id) {
		return studentService.getById(id);
	}

	@GetMapping("/code/{code}")
	public Student getStudentByCode(@PathVariable String code) {
		return studentService.getByStudentCode(code);
	}

	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable UUID id, @RequestBody Student student) {
		student.setId(id);
		return studentService.save(student);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable UUID id) {
		studentService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteAllStudents() {
		studentService.deleteAll();
		return ResponseEntity.noContent().build();
	}
}