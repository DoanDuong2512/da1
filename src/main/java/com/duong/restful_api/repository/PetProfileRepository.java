package com.duong.restful_api.repository;

import com.duong.restful_api.entity.PetProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetProfileRepository extends JpaRepository<PetProfile, Integer> {
    @Query("SELECT p FROM PetProfile p WHERE UPPER(p.medicalHistory) LIKE UPPER(CONCAT('%', :keyword, '%')) OR UPPER(p.vaccinationRecords) LIKE UPPER(CONCAT('%', :keyword, '%')) OR UPPER(p.dietaryRequirements) LIKE UPPER(CONCAT('%', :keyword, '%')) OR UPPER(p.specialCareInstructions) LIKE UPPER(CONCAT('%', :keyword, '%'))")
    List<PetProfile> findByMedicalHistoryContainingOrVaccinationRecordsContainingOrDietaryRequirementsContainingOrSpecialCareInstructionsContaining(@Param(value = "keyword") String keyword);
}
