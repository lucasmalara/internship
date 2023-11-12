package com.internship.adb.experimental.response.body;

import com.internship.adb.experimental.model.Person;
import lombok.Getter;

public class PersonResponseBody {
    @Getter private final Long id;
    @Getter private final String message;
    private static final String INTRODUCE = "Hello %s. It's nice to meet you.";

    public PersonResponseBody(Person person) {
        this.id = person.getId();
        this.message = buildMessage(person.getName());
    }

    private static String buildMessage(String name) {
        return String.format(INTRODUCE, name);
    }
}