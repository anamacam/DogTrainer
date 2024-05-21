package com.microservice.specialty.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DogDTO {


    private int id;
    private String name;
    private String breed;
    private Integer age;
    private String gender;
    private int specialtyId;
}
