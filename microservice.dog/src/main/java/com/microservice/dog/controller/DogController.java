package com.microservice.dog.controller;


import com.microservice.dog.entities.Dog;
import com.microservice.dog.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dog")
public class DogController {

    @Autowired
    private IDogService dogService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDog(@RequestBody Dog dog) {
        dogService.save(dog);

    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllDog() {
        return ResponseEntity.ok(dogService.findAll());
    }

    @GetMapping("search/{id}")
    public ResponseEntity<?> findAllById(@PathVariable int id) {
        Optional<Dog> specialty = Optional.ofNullable(dogService.findById(Math.toIntExact(id)));
        return specialty.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search-by-specialty/{idSpecialty}")
    public ResponseEntity<?> findByIdSpecialty(@PathVariable int idSpecialty) {
        List<Dog> dogs = dogService.findByIdSpecialty(Math.toIntExact(idSpecialty));
        return ResponseEntity.ok(dogs);
    }

}

