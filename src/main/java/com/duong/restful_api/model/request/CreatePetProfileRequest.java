package com.duong.restful_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePetProfileRequest {
    private int petId;
    private String medicalHistory;
    private String vaccinationRecords;
    private String dietaryRequirements;
    private String specialCareInstructions;
    private double weight;
}
