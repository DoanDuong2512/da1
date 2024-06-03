package com.duong.restful_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetProfileDto {

    private int profileId;
    private int petId;
    private String medicalHistory;
    private String vaccinationRecords;
    private String dietaryRequirements;
    private String specialCareInstructions;
    private double weight;

}

