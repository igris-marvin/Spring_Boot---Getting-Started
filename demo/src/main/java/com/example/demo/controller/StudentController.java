package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.StudentRepository;
import com.example.demo.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentRepository sRepo;

    @Autowired
    public StudentController(StudentRepository sRepo) {
        this.sRepo = sRepo;
    }

    /* REGISTERING STUDENTS */

    @GetMapping("/register")
    public String getStudentRegister() {

        return "register_page";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute(name = "student") Student student) {
        System.out.println(student.toString());
        
        sRepo.save(student);

        return "result_page";
    }

    @ModelAttribute(name = "student") //attaches a stuednt object for binding
    public Student getStudentObject() {

        return new Student();
    }

    /* DISPLAYING STUDENTS LIST */

    @ModelAttribute(name = "students", binding = false) //attaches a list of student from database to a model
    public List<Student> getStudentList() {

        List<Student> student_list = new ArrayList<>();

        student_list = (List<Student>) sRepo.findAll();

        return student_list;
    }
    
    @GetMapping("/student/display")
    public String getStudentDisplayer() {

        return "student_list";
    }
}