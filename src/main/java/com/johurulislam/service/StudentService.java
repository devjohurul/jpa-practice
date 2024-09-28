package com.johurulislam.service;

import com.johurulislam.model.Student;
import com.johurulislam.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final LaptopService laptopService;

    public StudentService(StudentRepository studentRepository, LaptopService laptopService) {
        this.studentRepository = studentRepository;
        this.laptopService = laptopService;
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public Optional<Student> getStudentById(Integer id){
        return studentRepository.findById(id);
    }
    public List<Student> getStudentByGender(String gender){
        return studentRepository.findByGender(gender);
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
