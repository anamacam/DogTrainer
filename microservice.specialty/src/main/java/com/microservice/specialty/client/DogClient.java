package com.microservice.specialty.client;

import com.microservice.specialty.dto.DogDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-dog", url = "http://localhost:8090/api/dog")
public interface DogClient {

    @GetMapping("api/dog/search-by-specialty/{idSpecialty}")
    List<DogDTO>findAllDogBySpecialty(@PathVariable int idSpecialty);
}
