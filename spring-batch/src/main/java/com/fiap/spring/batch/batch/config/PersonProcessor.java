package com.fiap.spring.batch.batch.config;

import com.fiap.spring.batch.batch.domain.Person;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;

public class PersonProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) throws Exception {
        person.setCreateDateTime(LocalDateTime.now());
        return person;
    }
}
