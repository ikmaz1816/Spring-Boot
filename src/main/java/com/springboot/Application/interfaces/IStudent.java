package com.springboot.Application.interfaces;

import com.springboot.Application.entity.Student;

import java.util.List;

public interface IStudent {

    boolean addStudent(Student s);

    boolean updateStudent(Student s);

    boolean deleteStudent(long id);

    Student getStudent(long id);

    List<Student> getAllStudent();
}
