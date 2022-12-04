package com.internship.adb.students.repository;

import com.internship.adb.students.entity.Student;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface StudentRepository extends JpaRepositoryImplementation<Student, Long> {
    List<Student> findBySurname(String surname);
    List<Student> findByAge(int age);
}
