package com.internship.adb.experimental.reponse.body;

import com.internship.adb.experimental.model.Person;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
public class PersonResponseBody {
    private final Long id;
    private final String message;
    @Getter(AccessLevel.NONE)
    private static final String INTRODUCE = "Hello %s. It's nice to meet you.";

    public PersonResponseBody(Person person) {
        this.id = person.getId();
        this.message = buildMessage(person.getName());
    }

    private static String buildMessage(String name) {
        return String.format(INTRODUCE, name);
    }
}