package com.lesson.demo07.controller;

import com.lesson.demo07.entity.Person;
import com.lesson.demo07.repository.PersonRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {
        personRepository.savePerson(person);
        return person;
    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable Long id) {
        return personRepository.findPerson(id);
    }

    @GetMapping("/del/{id}")
    public boolean del(@PathVariable Long id) {
        return personRepository.delPerson(id);
    }
}
