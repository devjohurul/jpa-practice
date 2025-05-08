package com.johurulislam.service;

import com.johurulislam.dto.StudentDto;
import com.johurulislam.model.Student;
import com.johurulislam.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentDto studentDto;
    private final LaptopService laptopService;

    public StudentService(StudentRepository studentRepository, LaptopService laptopService) {
        this.studentRepository = studentRepository;
        this.laptopService = laptopService;
        this.studentDto = new StudentDto();
    }

    public void addStudent(StudentDto studentdto){
        Student student = new Student();
        student.setName(studentdto.getName());
        student.setGender(studentdto.getGender());
        student.setLaptopList(studentdto.getLaptopList());
        student.setId(studentdto.getId());
        laptopService.getLaptopById(student.getId());
        studentRepository.save(student);
    }

    public Optional<StudentDto> getStudentById(Integer id){
        StudentDto studentDto = new StudentDto();
        Optional<Student> student = studentRepository.findById(id);
        studentDto.setId(student.get().getId());
        studentDto.setName(student.get().getName());
        studentDto.setGender(student.get().getGender());
        return Optional.of(studentDto);
    }

    public List<StudentDto> getAllStudents() {
    List<StudentDto> studentDtos = new ArrayList<>();
    List<Student> students = studentRepository.findAll();

    for (Student student : students) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setGender(student.getGender());
        studentDtos.add(studentDto);
    }
    return studentDtos;
    }


}


