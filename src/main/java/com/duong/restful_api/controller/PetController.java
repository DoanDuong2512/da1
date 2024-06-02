package com.duong.restful_api.controller;

import com.duong.restful_api.model.dto.PetDto;
import com.duong.restful_api.model.request.CreatePetRequest;
import com.duong.restful_api.model.request.UpdatePetRequest;
import com.duong.restful_api.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("")
    public ResponseEntity<?> getListPet() {
        List<PetDto> pets = petService.getListPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPet(@RequestParam(name="keyword", required = false, defaultValue = "") String keyword) {
        List<PetDto> pets = petService.searchPet(keyword);
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPetById(@PathVariable int id) {
        PetDto result = petService.getPetById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createPet(@Validated @RequestBody CreatePetRequest req) {
        PetDto result = petService.createPet(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePet(@PathVariable int id, @Validated @RequestBody UpdatePetRequest req) {
        PetDto result = petService.updatePet(id, req);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable int id) {
        petService.deletePet(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
