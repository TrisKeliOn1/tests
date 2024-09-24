package br.com.tdd.service;

import br.com.tdd.model.Person;

public class PersonService implements IPersonService{

    @Override
    public Person createPerson(Person person) {

        return new Person();
    }
}
