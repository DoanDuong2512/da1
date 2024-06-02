package com.duong.restful_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetDto {
    private int id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String healthInfo;
    private int customerId;
}