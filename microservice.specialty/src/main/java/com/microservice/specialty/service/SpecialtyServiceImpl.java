package com.microservice.specialty.service;

import com.microservice.specialty.client.DogClient;
import com.microservice.specialty.dto.DogDTO;
import com.microservice.specialty.entities.Specialty;
import com.microservice.specialty.http.response.DogBySpecialtyResponse;
import com.microservice.specialty.persistence.ISpecialtyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SpecialtyServiceImpl implements ISpecialtyService {

    private final ISpecialtyRepository specialtyRepository;
    private final DogClient dogClient;

    public SpecialtyServiceImpl(ISpecialtyRepository specialtyRepository, DogClient dogClient) {
        this.specialtyRepository = specialtyRepository;
        this.dogClient = dogClient;
    }

    @Override
    public List<Specialty> findAll() {
        return (List<Specialty>) specialtyRepository.findAll();
    }

    @Override
    public Specialty findById(int id) {
        return specialtyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Specialty not found with id: " + id));
    }

    @Override
    @Transactional
    public void save(Specialty specialty) {
        specialtyRepository.save(specialty);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public DogBySpecialtyResponse findDogsByIdSpecialty(int specialtyId) {
        Specialty specialty = specialtyRepository.findById(specialtyId)
                .orElseThrow(() -> new NoSuchElementException("Specialty not found with id: " + specialtyId));

        List<DogDTO> dogDTOList = dogClient.findAllDogBySpecialty(specialty.getId());

        return DogBySpecialtyResponse.builder()
                .specialtyName(specialty.getName())
                .trainer(specialty.getTrainer())
                .dogDTOList(dogDTOList)
                .build();
    }
}
