package com.microservice.specialty.http.response;


import com.microservice.specialty.dto.DogDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DogBySpecialtyResponse {

    private String specialtyName;
    private String trainer;
    private List<DogDTO> dogDTOList;
}
