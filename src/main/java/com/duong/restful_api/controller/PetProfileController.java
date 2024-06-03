package com.duong.restful_api.controller;

import com.duong.restful_api.model.dto.PetProfileDto;
import com.duong.restful_api.model.request.CreatePetProfileRequest;
import com.duong.restful_api.model.request.UpdatePetProfileRequest;
import com.duong.restful_api.service.PetProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet-profiles")
public class PetProfileController {
    @Autowired
    private PetProfileService petProfileService;

    @GetMapping("")
    public ResponseEntity<?> getListPetProfiles() {
        List<PetProfileDto> petProfiles = petProfileService.getListPetProfiles();
        return ResponseEntity.ok(petProfiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPetProfileById(@PathVariable int id) {
        PetProfileDto result = petProfileService.getPetProfileById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createPetProfile(@Validated @RequestBody CreatePetProfileRequest req) {
        PetProfileDto result = petProfileService.createPetProfile(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePetProfile(@PathVariable int id, @Validated @RequestBody UpdatePetProfileRequest req) {
        PetProfileDto result = petProfileService.updatePetProfile(id, req);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePetProfile(@PathVariable int id) {
        petProfileService.deletePetProfile(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}
