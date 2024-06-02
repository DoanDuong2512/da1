package com.duong.restful_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pet_profiles")
public class PetProfile {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String medicalHistory;

    private String vaccinationRecords;

    private String dietaryRequirements;

    private String specialCareInstructions;

    private java.math.BigDecimal weight;
    @OneToOne
    @JoinColumn(name = "pet_id")
    private Booking booking;
}
