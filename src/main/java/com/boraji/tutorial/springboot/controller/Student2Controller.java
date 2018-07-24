package com.boraji.tutorial.springboot.controller;

import com.boraji.tutorial.springboot.entity.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class Student2Controller {

    @RequestMapping("/showForm")
    public String showForm(Model theModel){

        Student2 theStudent2 =new Student2();
        theModel.addAttribute("student", theStudent2);

        return "student-form";
    }
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student2 theStudent2){
        System.out.println(theStudent2.getFirstName());
        System.out.println(theStudent2.getLastName());
        return "student-confirmation";
    }

}
