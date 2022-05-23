package com.udemy.person.adapter.mocks;

import com.udemy.person.data.model.Person;
import com.udemy.person.data.vo.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {
    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonVO mockVO() {
        return mockVO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<PersonVO>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }

    private Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Address test " + number);
        person.setFirstName("First name " + number);
        person.setLastName("Last name " + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        return person;
    }

    private PersonVO mockVO(Integer number) {
        PersonVO personVO = new PersonVO();
        personVO.setAddress("Address test " + number);
        personVO.setFirstName("First name " + number);
        personVO.setLastName("Last name " + number);
        personVO.setGender(((number % 2) == 0) ? "Male" : "Female");
        personVO.setId(number.longValue());
        return personVO;
    }
}
