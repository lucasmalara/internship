package com.internship.adb.students.service;

import com.internship.adb.students.entity.Student;
import com.internship.adb.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public List<Student> getStudentsBySurname(String surname) {
        return studentRepository.findBySurname(surname);
    }
}