package br.com.tdd.service;

import br.com.tdd.model.Person;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService{

    @Override
    public Person createPerson(Person person) {

        if (person.getEmail() == null || person.getEmail().isBlank()) throw new IllegalArgumentException("The Person Email is null or empty!");

        var id = new AtomicLong().incrementAndGet();
        person.setId(id);

        return person;
    }
}
