package com.demo.springsec.student;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo ){
        this.studentRepo = studentRepo;
    }
    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Welcome to student dashboard, running on session  "+  request.getSession().getId() ;
    }
    @PostMapping("/add")
    ResponseEntity<HttpStatus> addStudent(@RequestBody Student student){
        studentRepo.addStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/set/{id}")
    ResponseEntity<HttpStatus> setStudent(@PathVariable Integer id, @RequestBody Student student){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    ResponseEntity<Student> getStudent(@PathVariable Integer id){
        return new ResponseEntity<>(studentRepo.getStudent(id), HttpStatus.OK);
    }

    @GetMapping("/getallstudents")
    ResponseEntity<List<Student>> getALlStudents(){
        return new ResponseEntity<>(studentRepo.getAllStudents(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
        return new ResponseEntity<>(studentRepo.deleteStudent(id), HttpStatus.OK);
    }

    @GetMapping("/csrftoken")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
