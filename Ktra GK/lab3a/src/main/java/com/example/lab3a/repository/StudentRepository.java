package com.example.lab3a.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab3a.entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {

	java.util.Optional<Student> findByStudentCode(String studentCode);

	List<Student> findByStudentCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrClassNameContainingIgnoreCase(
			String studentCode, String fullName, String email, String phone, String className);
}