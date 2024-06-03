package com.duong.restful_api.repository;

import com.duong.restful_api.entity.PetCareLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetCareLogRepository extends JpaRepository<PetCareLog, Integer> {
    List<PetCareLog> findByPetId(int petID);
}
