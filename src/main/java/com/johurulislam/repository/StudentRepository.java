package com.johurulislam.repository;

import com.johurulislam.dto.StudentDto;
import com.johurulislam.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<StudentDto> findByGender(String gender);
}
