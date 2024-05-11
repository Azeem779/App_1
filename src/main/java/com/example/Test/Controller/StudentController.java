package com.example.Test.Controller;


import com.example.Test.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(
                "John","doe",1
        );
        return student;
    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kane","Wellington",1));
        students.add(new Student("Drew","Brandon",2));
        students.add(new Student("Mitch","Marsh",3));
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getId());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,  @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
