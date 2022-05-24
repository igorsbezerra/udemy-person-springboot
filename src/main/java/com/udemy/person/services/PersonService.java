package com.udemy.person.services;

import com.udemy.person.adapter.mapper.DozerAdapter;
import com.udemy.person.data.vo.PersonVO;
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

    public PersonVO create(PersonVO person) {
        var entity = DozerAdapter.parseObject(person, Person.class);
        return DozerAdapter.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        var entity = personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found for ID " + id));
        return DozerAdapter.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        return DozerAdapter.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO update(Long id, PersonVO person) {
        findById(id);
        person.setId(id);
        personRepository.save(DozerAdapter.parseObject(person, Person.class));
        return DozerAdapter.parseObject(person, PersonVO.class);
    }

    public void delete(Long id) {
        findById(id);
        personRepository.deleteById(id);
    }
}
