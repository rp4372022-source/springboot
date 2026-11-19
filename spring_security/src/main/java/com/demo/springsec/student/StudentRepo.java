package com.demo.springsec.student;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepo {

    List<Student> studentList = new ArrayList<>(List.of(
            new Student(101,"Rutik","Computer"),
            new Student(102,"Kunal","Electronics"),
            new Student(103,"Aryan","Mechanical")
    ));
    public void addStudent(Student student){
        studentList.add(student);
    }

    public Student getStudent(Integer id){
        return studentList.stream().
                filter(s -> Objects.equals(s.getStudentId(), id)).
                findFirst().
                orElse(
                        new Student(0,"No student","no course")
                );

    }

    public void setStudent(Integer id, Student student){
        for(Student s:studentList){
            if(Objects.equals(s.getStudentId(), id)){
                s.setStudentName(student.getStudentName());
                s.setCourseName(student.getCourseName());
                break;
            }
        }
    }

    public Student deleteStudent(Integer id){
        Student studentToRemove = getStudent(id);
        if (studentToRemove.getStudentId() != 0) {
            studentList.remove(studentToRemove);
        }
        return studentToRemove;
    }

    public List<Student> getAllStudents(){
        return studentList;
    }

}
