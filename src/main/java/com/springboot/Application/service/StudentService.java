package com.springboot.Application.service;

import com.springboot.Application.entity.Student;
import com.springboot.Application.interfaces.IStudent;
import com.springboot.Application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudent {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public boolean addStudent(Student s) {
       Student stud=studentRepository.save(s);
       if(stud==null)
       {
           return false;
       }
       return true;
    }

    @Override
    public boolean updateStudent(Student s) {
        Student stud=studentRepository.save(s);
        if(stud==null)
            return false;
        return true;
    }

    @Override
    public boolean deleteStudent(long id) {
        Student stud=studentRepository.findById(id).get();
        if(stud==null)
            return true;
        return false;
    }

    @Override
    public Student getStudent(long id){
        Student stud=studentRepository.findById(id).get();
        return  stud;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students=(List<Student>)studentRepository.findAll();
        return students;
    }
}
