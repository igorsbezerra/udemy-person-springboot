package com.udemy.person.services;

import com.udemy.person.exception.NotFoundException;
import com.udemy.person.data.model.Person;
import com.udemy.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found for ID " + id));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person update(Long id, Person person) {
        findById(id);
        person.setId(id);
        return personRepository.save(person);
    }

    public void delete(Long id) {
        Person person = findById(id);
        personRepository.delete(person);
    }
}
