package com.springboot.Application.controller;

import com.springboot.Application.entity.Student;
import com.springboot.Application.exception.StudentException;
import com.springboot.Application.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    private final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @PostMapping("/addStudent/{s}")
    public void addStudent(@RequestBody Student s) throws Exception
    {
        logger.info("Student adding process started");
        if(!studentService.addStudent(s)) {
            logger.warn("Issues with adding student");
            throw new StudentException("Student not found");
        }
        logger.info("Student added successfully");
    }

    @PutMapping("/updateStudent/{s}")
    public void updateStudent(@RequestBody Student s) throws StudentException
    {
        logger.info("Student update process started");
        if(!studentService.updateStudent(s)) {
            logger.warn("Issues with updating student");
            throw new StudentException("Student not found");
        }
        logger.info("Student updated successfully");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable  long id) throws StudentException
    {
        logger.info("Student delete process started");
        if(!studentService.deleteStudent(id)) {
            logger.warn("Issues with deleting student");
            throw new StudentException("Student not found");
        }
        logger.info("Student deleted successfully");
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable long id) throws StudentException
    {
        logger.info("Process started");
       Student student=studentService.getStudent(id);
        if(student==null)
        {
            throw new StudentException("Student Not Found");
        }
        logger.info("Process Completed successfully");
        return student;
    }
    @GetMapping("/getStudents")
    @ResponseBody
    public List<Student> getAllStudent() throws StudentException
    {
        logger.info("Process started");
        List<Student> student=studentService.getAllStudent();
        if(student==null || student.size()==0)
        {
            throw new StudentException("Student Not Found");
        }
        logger.info("Process Completed successfully");
        return student;

    }
}
