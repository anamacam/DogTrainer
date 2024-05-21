package com.microservice.dog.service;

import com.microservice.dog.entities.Dog;
import com.microservice.dog.persistence.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements IDogService{

    @Autowired
    private DogRepository dogRepo;

    @Override
    public List<Dog> findAll() {
        return (List<Dog>) dogRepo.findAll();
    }

    @Override
    public Dog findById(int id) {
        return (Dog) dogRepo.findById((int) id).orElseThrow(() -> new RuntimeException(STR."Dog not found\{id}"));
    }

    @Override
    public void save(Dog dog) {
        dogRepo.save(dog);
    }

    @Override
    public List<Dog> findByIdSpecilty(int idSpecilaty) {
        return dogRepo.findAllDog((int) idSpecilaty);
    }

    @Override
    public void deleteById(int id) {
        dogRepo.deleteById(id);
    }

    @Override
    public List<Dog> findByIdSpecialty(int idSpecialty) {
        return dogRepo.findAllDogBySpecialtyId((int) idSpecialty);
    }
}