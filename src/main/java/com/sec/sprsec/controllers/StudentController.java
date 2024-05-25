package com.sec.sprsec.controllers;

import com.sec.sprsec.models.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>();
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/students")
    public List<Student> students(){

        Student student1= new Student(1, "Harry", "Kane");
        Student student2= new Student(2, "Trevor", "Chalobah");
        Student student3= new Student(3, "Cole", "Palmer");
        Student student4= new Student(4, "Thiago", "Silva");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        return students;

    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students")
    public Student createStudent(Student student){
        students.add(student);
        return student;
    }

    @GetMapping("/testmsg")
    public String getMessage(){
        return ("This is the test message");
    }
}
