package com.duong.restful_api.service;
import com.duong.restful_api.entity.PetProfile;
import com.duong.restful_api.exception.NotFoundException;
import com.duong.restful_api.model.dto.PetProfileDto;
import com.duong.restful_api.model.request.CreatePetProfileRequest;
import com.duong.restful_api.model.request.UpdatePetProfileRequest;
import com.duong.restful_api.repository.PetProfileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetProfileService {
    @Autowired
    private PetProfileRepository petProfileRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PetProfileDto> getListPetProfiles() {
        List<PetProfile> petProfiles = petProfileRepository.findAll();
        List<PetProfileDto> result = new ArrayList<>();
        for (PetProfile petProfile : petProfiles) {
            result.add(modelMapper.map(petProfile, PetProfileDto.class));
        }
        return result;
    }

    public PetProfileDto getPetProfileById(int id) {
        PetProfile petProfile = petProfileRepository.findById(id).orElse(null);
        if (petProfile == null) {
            throw new NotFoundException("Không tìm thấy hồ sơ của thú cưng");
        }
        return modelMapper.map(petProfile, PetProfileDto.class);
    }

    public PetProfileDto createPetProfile(CreatePetProfileRequest req) {
        PetProfile petProfile = new PetProfile();
        petProfile.setId(req.getPetId());
        petProfile.setMedicalHistory(req.getMedicalHistory());
        petProfile.setVaccinationRecords(req.getVaccinationRecords());
        petProfile.setDietaryRequirements(req.getDietaryRequirements());
        petProfile.setSpecialCareInstructions(req.getSpecialCareInstructions());
        petProfile.setWeight(req.getWeight());
        petProfileRepository.save(petProfile);
        return modelMapper.map(petProfile, PetProfileDto.class);
    }

    public PetProfileDto updatePetProfile(int id, UpdatePetProfileRequest req) {
        PetProfile petProfile = petProfileRepository.findById(id).orElse(null);
        if (petProfile == null) {
            throw new NotFoundException("Không tìm thấy hồ sơ của thú cưng");
        }
        petProfile.setId(req.getPetId());
        petProfile.setMedicalHistory(req.getMedicalHistory());
        petProfile.setVaccinationRecords(req.getVaccinationRecords());
        petProfile.setDietaryRequirements(req.getDietaryRequirements());
        petProfile.setSpecialCareInstructions(req.getSpecialCareInstructions());
        petProfile.setWeight(req.getWeight());
        petProfileRepository.save(petProfile);
        return modelMapper.map(petProfile, PetProfileDto.class);
    }

    public void deletePetProfile(int id) {
        PetProfile petProfile = petProfileRepository.findById(id).orElse(null);
        if (petProfile == null) {
            throw new NotFoundException("Không tìm thấy hồ sơ của thú cưng");
        }
        petProfileRepository.delete(petProfile);
    }
}
