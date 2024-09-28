package com.johurulislam.service;

import com.johurulislam.model.Laptop;
import com.johurulislam.repository.LaptopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    public void addLaptop(Laptop laptop) {
        new ResponseEntity<>(laptopRepository.save(laptop), HttpStatus.CREATED);
    }
    public ResponseEntity<?> getLaptopById(Integer id) {
        Optional<Laptop> laptop = laptopRepository.findById(id);
        return new ResponseEntity<>(laptop.orElse(null), HttpStatus.OK);
    }
}
