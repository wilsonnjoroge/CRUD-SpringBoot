package com.example.Wilson3.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "/application")
public class StudentControler {

    private final StudentService studentService;

    @Autowired
    public StudentControler(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/details")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping("/add")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping({"id"})
    public void deleteStudent(@PathVariable("id") Long id){
        
        studentService.deleteStudent(id);
    }
}
