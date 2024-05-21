package com.microservice.dog.persistence;

import com.microservice.dog.entities.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface DogRepository extends Repository<Dog, Integer> {

    @Query("SELECT d FROM Dog d WHERE d.specialtyId = :idSpecialty")
    List<Dog> findAllDog(int idSpecialty);

    List<Dog> findAll();

    ScopedValue<Object> findById(int id);

    void save(Dog dog);

    void deleteById(int id);

    List<Dog> findAllDogBySpecialtyId(int idSpecialty);


    //List<Dog> findAllBySpecialtyId(Long idSpecialty);
}
