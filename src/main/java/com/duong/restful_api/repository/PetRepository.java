package com.duong.restful_api.repository;

import com.duong.restful_api.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Query("SELECT p FROM Pet p WHERE UPPER(p.name) LIKE UPPER(CONCAT('%', :keyword, '%')) OR UPPER(p.species) LIKE UPPER(CONCAT('%', :keyword, '%'))")
    List<Pet> findByNameContainingOrSpeciesContaining(@Param(value = "keyword") String keyword);
}