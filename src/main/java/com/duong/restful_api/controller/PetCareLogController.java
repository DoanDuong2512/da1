package com.duong.restful_api.controller;

import com.duong.restful_api.model.dto.PetCareLogDto;
import com.duong.restful_api.model.request.CreatePetCareLogRequest;
import com.duong.restful_api.model.request.UpdatePetCareLogRequest;
import com.duong.restful_api.service.PetCareLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet-care-logs")
public class PetCareLogController {
    @Autowired
    private PetCareLogService petCareLogService;

    @GetMapping("")
    public ResponseEntity<?> getListPetCareLogs() {
        List<PetCareLogDto> petCareLogs = petCareLogService.getListPetCareLogs();
        return ResponseEntity.ok(petCareLogs);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPetCareLogById(@PathVariable int id) {
        PetCareLogDto result = petCareLogService.getPetCareLogById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createPetCareLog(@Validated @RequestBody CreatePetCareLogRequest req) {
        PetCareLogDto result = petCareLogService.createPetCareLog(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePetCareLog(@PathVariable int id, @Validated @RequestBody UpdatePetCareLogRequest req) {
        PetCareLogDto result = petCareLogService.updatePetCareLog(id, req);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePetCareLog(@PathVariable int id) {
        petCareLogService.deletePetCareLog(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}
