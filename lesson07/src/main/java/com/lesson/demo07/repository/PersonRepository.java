package com.lesson.demo07.repository;

import com.lesson.demo07.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository {

    @Cacheable(cacheNames = "persons")
    Person findPerson(Long id);

    boolean savePerson(Person person);

    boolean delPerson(Long id);

}
