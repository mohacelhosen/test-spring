package com.test.testproject.controller;

import com.test.testproject.model.Student;
import com.test.testproject.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class TestController {
    @Autowired

    private StudentService service;

    @GetMapping
    public ResponseEntity greeting(){
        String msg= "Welcome to Coding world ";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody Student student, HttpServletRequest request){
        Map<String, Object> response = new HashMap<>();
        Student dbStudent = service.saveStudent(student);
        response.put("data", dbStudent);
        response.put("path", request.getRequestURI());
        response.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Student studentById = service.findStudentById(id);
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

}
