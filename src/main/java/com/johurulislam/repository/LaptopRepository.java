package com.johurulislam.repository;

import com.johurulislam.model.Laptop;
import com.johurulislam.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
