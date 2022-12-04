package com.internship.adb.students.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentAgeGenerator {

    @Getter
    private static final int MIN_AGE = 18;

    private static final int MAX_AGE = 26;

    public static int getRandomAge() {
        return ThreadLocalRandom.current().nextInt(MIN_AGE, MAX_AGE + 1);
    }
}