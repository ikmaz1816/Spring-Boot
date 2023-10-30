package com.springboot.Application;

import com.springboot.Application.entity.Student;
import com.springboot.Application.repository.StudentRepository;
import com.springboot.Application.service.StudentService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceLayerTesting {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setup()
    {
        Student s=Student.builder().id(1L).name("Imran").courseName("Computer").yearOFAdmission("2019").bloodGroup('B').address("1151").build();
        List<Student> list=new ArrayList<>();
        list.add(s);
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.ofNullable(s));
        Mockito.when(studentRepository.findAll()).thenReturn(list);
    }

    @Test
    void  checkForStudentId()
    {
        Student s=studentService.getStudent(1L);
        assertEquals(1,s.getId());
    }

    @Test
    void checkForAllStudentData()
    {
        List<Student> s=studentService.getAllStudent();
        assertEquals(s.get(0).getName(),"Imran");
    }

    @Test
    void checkForUpdateData()
    {
        Student s=Student.builder().id(1L).name("Imran").courseName("Mechanical").yearOFAdmission("2019").bloodGroup('B').address("1151").build();
        Mockito.when(studentRepository.save(s)).thenReturn(s);
        System.out.println(studentService.updateStudent(s));
    }

    @Test
    void checkForAddData()
    {
        Student s=Student.builder().id(2L).name("Ayaan").courseName("Mechanical").yearOFAdmission("2019").bloodGroup('B').address("2608").build();
        Mockito.when(studentRepository.save(s)).thenReturn(s);
        System.out.println(studentService.addStudent(s));
    }

}
