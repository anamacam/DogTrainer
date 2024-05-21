package com.microservice.specialty.persistence;

import com.microservice.specialty.entities.Specialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISpecialtyRepository extends CrudRepository<Specialty, Integer> {
    Optional<Specialty> findById(int id);
}
