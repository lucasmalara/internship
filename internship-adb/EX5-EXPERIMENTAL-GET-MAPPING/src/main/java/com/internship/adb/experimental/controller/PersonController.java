package com.internship.adb.experimental.controller;

import com.internship.adb.experimental.model.Person;
import com.internship.adb.experimental.reponse.body.PersonResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.internship.adb.experimental.model.Person.DEFAULT_NAME;

@Controller
public class PersonController {

    @GetMapping("/meeting")
    @ResponseBody
    public ResponseEntity<PersonResponseBody> letsMeet(@RequestParam(value = "name", defaultValue = DEFAULT_NAME)
                                                         String name) {
        HttpStatus status = HttpStatus.OK;
        if(Person.isDefaultName(name)) {
            status = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(status).body(new PersonResponseBody(new Person(name)));
    }
}