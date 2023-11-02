package com.example.exo3.controllers;

import com.example.exo3.model.Student;
import com.example.exo3.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    private final IStudentService studentService;

    @Autowired
    private StudentRestController(IStudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}") // http://localhost:8080/api/v1/students/x
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping // http://localhost:8080/api/v1/students
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}") // http://localhost:8080/api/v1/students/x
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}") // http://localhost:8080/api/v1/students/x
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
