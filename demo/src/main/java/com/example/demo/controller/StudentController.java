package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.StudentRepository;
import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentRepository sRepo;

    @Autowired
    public StudentController(StudentRepository sRepo) {
        this.sRepo = sRepo;
    }

    @ModelAttribute(name = "student_list")
    public Student getStudent() {

        Optional<Student> s = sRepo.findById(2);
        Student student = s.orElse(new Student(0, "none", "none"));

        return student;
    }

    @ModelAttribute
    public Student 
    
    @GetMapping("/display")
    public String getStudentDisplayer() {
        return "student_list";
    }

    @GetMapping("/register")
    public String getStudentRegister() {
        return "register";
    }
    
}
