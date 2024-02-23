package com.example.Wilson3.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student>studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException(
                    "Email already taken"
            );
        }

        studentRepository.save(student);

    }

    public void deleteStudent(Long id){
        boolean exists = studentRepository.existsById(id);

        if(!exists){
            throw new IllegalStateException(
                    "Student with Id: " + id + " does not exist"
            );
        }

        studentRepository.deleteById(id);
    }
}
