package com.internship.adb.students.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueGetter {
    @Value("${instances.number}")
    private String value;

    public int getValue() {
        return Integer.parseInt(value);
    }
}