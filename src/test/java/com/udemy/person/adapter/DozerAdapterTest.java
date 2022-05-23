package com.udemy.person.adapter;

import com.udemy.person.adapter.mocks.MockPerson;
import com.udemy.person.data.model.Person;
import com.udemy.person.data.vo.PersonVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DozerAdapterTest {

    @Autowired
    MockPerson inputObject;

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerAdapter.parseObject(inputObject.mockEntity(), PersonVO.class);

        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First name 0", output.getFirstName());
        Assert.assertEquals("Last name 0", output.getLastName());
        Assert.assertEquals("Address test 0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerAdapter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outpuZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outpuZero.getId());
        Assert.assertEquals("First name 0", outpuZero.getFirstName());
        Assert.assertEquals("Last name 0", outpuZero.getLastName());
        Assert.assertEquals("Address test 0", outpuZero.getAddress());
        Assert.assertEquals("Male", outpuZero.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerAdapter.parseObject(inputObject.mockVO(), Person.class);

        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First name 0", output.getFirstName());
        Assert.assertEquals("Last name 0", output.getLastName());
        Assert.assertEquals("Address test 0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
    }

    @Test
    public void parseVOListToEntityListTest() {
        List<Person> outputList = DozerAdapter.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outpuZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outpuZero.getId());
        Assert.assertEquals("First name 0", outpuZero.getFirstName());
        Assert.assertEquals("Last name 0", outpuZero.getLastName());
        Assert.assertEquals("Address test 0", outpuZero.getAddress());
        Assert.assertEquals("Male", outpuZero.getGender());
    }
}
