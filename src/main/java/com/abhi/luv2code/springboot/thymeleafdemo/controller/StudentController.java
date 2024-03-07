package com.abhi.luv2code.springboot.thymeleafdemo.controller;

import com.abhi.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programming-language}")
    private List<String> programmingLanguage;

    @Value("${operating-system}")
    private List<String> operatingSystem;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        // create a student object
        Student theStudent = new Student();

        // add to the model
        theModel.addAttribute("student", theStudent);

        // add the countries to the model

        theModel.addAttribute("countries",countries);

        // add the programming language to the model

        theModel.addAttribute("programmingLanguage",programmingLanguage);

        // add operating system

        theModel.addAttribute("operatingSystem",operatingSystem);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        //log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() +
                " " + theStudent.getLastName() +
                " " + theStudent.getCountry());

        return "student-confirmation";
    }
}
