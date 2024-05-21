package com.microservice.specialty.controller;

import com.microservice.specialty.entities.Specialty;
import com.microservice.specialty.http.response.DogBySpecialtyResponse;
import com.microservice.specialty.service.ISpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/specialties")
public class SpecialtyController {

    @Autowired
    private ISpecialtyService specialtyService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSpecialty(@RequestBody Specialty specialty) {
        specialtyService.save(specialty);

    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllSpecialty() {
        return ResponseEntity.ok(specialtyService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok(specialtyService.findById(id));
    }

    @GetMapping("/search-dog/{especialtyId}")
    public ResponseEntity<?> findDogsBySpecialtyID(@PathVariable int especialtyId) {
        return ResponseEntity.ok(specialtyService.findDogsByIdSpecialty(especialtyId));
    }
}



