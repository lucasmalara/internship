package com.internship.adb.students.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.datafaker.Faker;

import javax.persistence.*;

import static com.internship.adb.students.utils.StudentAgeGenerator.getRandomAge;

@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    @Setter(AccessLevel.NONE)
    private int id;

    @Column
    private String name;

    @Getter
    @Column
    private String surname;

    @Column
    private int age;

    public static Student randomStudent() {
        Student student = new Student();
        Faker dataFaker = new Faker();
        student.setName(dataFaker.name().firstName());
        student.setSurname(dataFaker.name().lastName());
        student.setAge(getRandomAge());
        return student;
    }
}