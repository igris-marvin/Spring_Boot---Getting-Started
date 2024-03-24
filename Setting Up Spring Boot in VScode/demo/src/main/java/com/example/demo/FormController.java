package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FormController { //Servlet of some sort
    
    @PostMapping("/greeting")
    public String postMethodName(@RequestParam String username, @RequestParam String password, Model model) {
        //TODO: process POST request

        model.addAttribute("username", username);
        
        return "result";
    }
    
}
