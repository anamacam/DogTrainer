package com.microservice.specialty.service;

import com.microservice.specialty.entities.Specialty;
import com.microservice.specialty.http.response.DogBySpecialtyResponse;

import java.util.List;

public interface ISpecialtyService {

    List<Specialty> findAll();

    Specialty findById(int id);

    void save(Specialty specialty);

    void deleteById(int id);

    DogBySpecialtyResponse findDogsByIdSpecialty(int idSpecialty);
}

