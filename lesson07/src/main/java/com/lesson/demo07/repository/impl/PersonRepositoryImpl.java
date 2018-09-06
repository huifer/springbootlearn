package com.lesson.demo07.repository.impl;

import com.lesson.demo07.entity.Person;
import com.lesson.demo07.repository.PersonRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private final Map<String, Person> repoistory = new HashMap<>();

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean delPerson(Long id) {
        redisTemplate.delete(id);
        return true;
    }



    @Override
    public Person findPerson(Long id) {

        Person person = (Person) redisTemplate.opsForValue().get(id);

        return person;
    }

    @Override
    public boolean savePerson(Person person) {
        redisTemplate.opsForValue().set(person.getId(), person);

        return true;
    }
}
