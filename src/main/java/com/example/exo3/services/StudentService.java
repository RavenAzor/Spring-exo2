package com.example.exo3.services;

import com.example.exo3.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService{

    private List<Student> students = new ArrayList<>();

    private Long currentId = 1L;

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        student.setId(currentId);
        currentId++;
        students.add(student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student updateStudent) {
        Student student = getStudentById(id);
        if(student != null){
            student.setName(updateStudent.getName());
            student.setAge(updateStudent.getAge());
        }
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
