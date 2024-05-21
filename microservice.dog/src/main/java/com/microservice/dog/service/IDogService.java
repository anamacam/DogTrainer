package com.microservice.dog.service;

import com.microservice.dog.entities.Dog;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface IDogService {

    List<Dog> findAll();
    Dog findById(int id);


    void save(Dog dog);


    List<Dog> findByIdSpecilty(int idSpecilaty);

    void deleteById(int id);

    List<Dog> findByIdSpecialty(int idSpecialty);
}
