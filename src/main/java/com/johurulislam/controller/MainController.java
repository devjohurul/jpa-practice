package com.johurulislam.controller;

import com.johurulislam.model.Laptop;
import com.johurulislam.model.Student;
import com.johurulislam.service.LaptopService;
import com.johurulislam.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    private final StudentService studentService;
    private final LaptopService laptopService;

    public MainController(StudentService studentService, LaptopService laptopService) {
        this.studentService = studentService;
        this.laptopService = laptopService;
    }
    @GetMapping("student/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Integer id) {
    return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }
    @GetMapping("/student/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("student/g/{gender}")
    public ResponseEntity<List<Student>> getStudentById(@PathVariable String gender) {
        return new ResponseEntity<>(studentService.getStudentByGender(gender),HttpStatus.OK);
    }
    @PostMapping("/addstudent")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>("Save Student", HttpStatus.CREATED);
    }
    @PostMapping("/addlaptop")
    public ResponseEntity<?> addLaptop(@RequestBody Laptop laptop) {
        laptopService.addLaptop(laptop);
        return new ResponseEntity<>("Save Laptop", HttpStatus.CREATED);
    }

}
