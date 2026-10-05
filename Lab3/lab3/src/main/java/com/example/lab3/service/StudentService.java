package com.example.lab3.service;

import com.example.lab3.entity.Student;
import com.example.lab3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(UUID id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với id: " + id));
    }

    public Student findByCode(String studentCode) {
        return studentRepository.findByStudentCodeIgnoreCase(studentCode)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với mã: " + studentCode));
    }

    public List<Student> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return studentRepository.findAll();
        }

        String key = keyword.trim();
        return studentRepository.findByStudentCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrClassNameContainingIgnoreCase(
                key, key, key, key, key
        );
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(UUID.randomUUID());
        }

        if (studentRepository.findByStudentCodeIgnoreCase(student.getStudentCode()).isPresent()) {
            throw new RuntimeException("Mã sinh viên đã tồn tại: " + student.getStudentCode());
        }

        return studentRepository.save(student);
    }

    public Student update(UUID id, Student student) {
        Student existing = findById(id);

        existing.setStudentCode(student.getStudentCode());
        existing.setFullName(student.getFullName());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        existing.setClassName(student.getClassName());

        return studentRepository.save(existing);
    }

    public void deleteById(UUID id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy sinh viên với id: " + id);
        }
        studentRepository.deleteById(id);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
 