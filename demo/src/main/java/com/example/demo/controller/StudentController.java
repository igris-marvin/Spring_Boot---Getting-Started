package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.data.StudentRepository;
import com.example.demo.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository sRepo;

    public StudentController(StudentRepository sRepo) {
        this.sRepo = sRepo;
    }

    /* REGISTERING STUDENTS */

    @GetMapping("/register")
    public String getStudentRegister() {

        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute(name = "student_object") Student student) {
        System.out.println(student.toString());
        
        sRepo.save(student);

        return "result_page";
    }

    @ModelAttribute(name = "student_object") //attaches a student object for binding
    public Student getStudentObject() {

        return new Student();
    }

    /* DISPLAYING STUDENTS LIST */

    @ModelAttribute(name = "students", binding = false) //attaches a list of student from database to a model
    public List<Student> getStudentList() {

        List<Student> student_list = (List<Student>) sRepo.findAll();

        return student_list;
    }
    
    @GetMapping("/display")
    public String getStudentDisplayer() {

        return "student_list";
    }

    /* UPDATE STUDENT */

    @GetMapping("/update")
    public String getStudentUpdater(
        Model model,
        @RequestParam("updateid") Integer id
    ) {
        System.out.println("---------------------------------------------------");
        System.out.println("Student ID -> " + id);
        System.out.println("---------------------------------------------------");

        Student student = sRepo.findById(id).get();

        System.out.println("---------------------------------------------------");
        System.out.println(student.toString());
        System.out.println("---------------------------------------------------");
        
        model.addAttribute(
            "student", 
            student
        );

        return "update";
    }

    @PostMapping("/update")
    public String updateStudent(
        @ModelAttribute(name = "student") Student student
    ) {

        System.out.println("--------------------------------------------");
        System.out.println(student.toString());
        System.out.println("--------------------------------------------");

        sRepo.save(student);

        return "redirect:/student/display";
    }

    /* DELETE STUDENT */

    @GetMapping("/delete")
    public String deleteStudent(
        @RequestParam("deleteid") Integer deleteid
    ) {
        sRepo.deleteById(deleteid);

        return "redirect:/student/display";
    }

}