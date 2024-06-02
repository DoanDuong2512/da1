package com.duong.restful_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePetRequest {
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String healthInfo;
    private int customerId;
}