package com.test.testproject.service;

import com.test.testproject.model.Student;
import com.test.testproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudentById(String id){
        return studentRepository.findById(id).orElse(null);
    }
}
