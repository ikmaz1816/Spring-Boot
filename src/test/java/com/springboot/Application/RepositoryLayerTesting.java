package com.springboot.Application;

import com.springboot.Application.entity.Student;
import com.springboot.Application.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryLayerTesting {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setup()
    {
        Student s=Student.builder().id(1L).name("Imran").courseName("Computer").yearOFAdmission("2019").bloodGroup('B').address("1151").build();
        entityManager.persist(s);
    }

    @Test
    void checkForId()
    {
        Student s=studentRepository.findById(1L).get();
        assertEquals(s.getId(),1L);
    }
}
