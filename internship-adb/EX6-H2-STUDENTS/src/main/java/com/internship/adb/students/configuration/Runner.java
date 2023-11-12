package com.internship.adb.students.configuration;

import com.internship.adb.students.component.ValueGetter;
import com.internship.adb.students.entity.Student;
import com.internship.adb.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.internship.adb.students.utils.StudentAgeGenerator.getMIN_AGE;

@Configuration
public class Runner implements CommandLineRunner {

    private final ValueGetter valueGetter;

    private final StudentService studentService;

    private final List<Student> localStudents = new ArrayList<>();

    private static final String SURNAME = "Lopez";

    @Autowired
    public Runner(ValueGetter valueGetter, StudentService studentService) {
        this.valueGetter = valueGetter;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) {
        System.out.println();
        int value = valueGetter.getValue();
        int i;
        for (i = 1; i <= value; i++) {
            localStudents.add(Student.randomStudent());
        }
        int upperBound = (int) Math.floor((value * 0.3d));
        while(localStudents.stream()
                .filter(student -> Objects.equals(SURNAME, student.getSurname()))
                .count() != upperBound) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, localStudents.size());
            Student randomStudent = localStudents.get(randomIndex);
            if (!Objects.equals(SURNAME, randomStudent.getSurname())) {
                randomStudent.setSurname(SURNAME);
            }
        }
        localStudents.forEach(studentService::addStudent);
        System.out.println(value + " - number of created "
                + Student.class.getSimpleName() + " entities.");

        List<Student> foundByAge = new ArrayList<>();
        for (i = getMIN_AGE(); i < 20; i++) {
            foundByAge.addAll(studentService.getStudentsByAge(i));
        }
        System.out.println("Found students before their 20s: ");
        if (!foundByAge.isEmpty()) {
            foundByAge.forEach(System.out::println);
        } else System.out.println("None.");
        System.out.println();

        List<Student> foundBySurname = studentService.getStudentsBySurname(SURNAME);
        System.out.println("Found students named " + SURNAME + ":");
        if (!foundBySurname.isEmpty()) {
            foundBySurname.forEach(System.out::println);
        } else System.out.println("None.");
        System.out.println();

        System.out.println("All students:");
        studentService.getStudents().forEach(System.out::println);
    }
}