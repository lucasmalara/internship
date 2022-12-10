package com.internship.adb.experimental.model;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

public class Person {
    @Getter
    private final Long id;
    @Getter
    private final String name;
    public static final String DEFAULT_NAME = "stranger";
    private static final AtomicLong NUMERATION = new AtomicLong();

    public Person(String name) {
        this.name = adjustName(name);
        this.id = generateId();
    }

    private Long generateId() {
        return isDefaultName(this.name) ? 0L : NUMERATION.incrementAndGet();
    }

    public static boolean isDefaultName(String name) {
        return DEFAULT_NAME.equals(name);
    }

    private static String adjustName(String name) {
        if (name.matches("^(?!.*[\r\n])[\\da-zA-Z ]+$")) {
            String[] split = name.split(" ");
            StringBuilder adjustedName = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                String partOfName = split[i];
                if (!partOfName.isBlank()) {
                    adjustedName.append(partOfName);
                    if (i != split.length - 1) {
                        adjustedName.append(" ");
                    }
                }
            }
            return adjustedName.toString();
        } else {
            return DEFAULT_NAME;
        }
    }
}