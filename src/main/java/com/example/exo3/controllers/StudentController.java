package com.example.exo3.controllers;

import com.example.exo3.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/form")
    public String formPage(Model model){
        Student student = new Student();
        model.addAttribute("studentSubmit", student);
        return "form";
    }

    @GetMapping("/list")
    @ResponseBody
    public String listPage(Model model){
        List<Student> students = new ArrayList<>();
        model.addAttribute("students", students);
        return "/list";
    }

    @PostMapping("/submitStudent")
    public String submitStudent(@ModelAttribute("studentSubmit") Student student){
        System.out.println(student);
        return "redirect:/students/list";
    }
}
