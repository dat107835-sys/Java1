package com.example.lab3.repository;

import com.example.lab3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findByStudentCodeIgnoreCase(String studentCode);

    List<Student> findByStudentCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrClassNameContainingIgnoreCase(
            String studentCode,
            String fullName,
            String email,
            String phone,
            String className
    );
}