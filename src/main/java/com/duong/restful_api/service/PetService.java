package com.duong.restful_api.service;

import com.duong.restful_api.entity.Pet;
import com.duong.restful_api.exception.NotFoundException;
import com.duong.restful_api.model.dto.PetDto;
import com.duong.restful_api.model.request.CreatePetRequest;
import com.duong.restful_api.model.request.UpdatePetRequest;
import com.duong.restful_api.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PetDto> getListPets() {
        List<Pet> pets = petRepository.findAll();
        List<PetDto> result = new ArrayList<>();
        for (Pet pet : pets) {
            result.add(modelMapper.map(pet, PetDto.class));
        }
        return result;
    }

    public PetDto getPetById(int id) {
        Pet pet = petRepository.findById(id).orElse(null);
        if (pet == null) {
            throw new NotFoundException("Pet not found");
        }
        return modelMapper.map(pet, PetDto.class);
    }

    public List<PetDto> searchPet(String keyword) {
        List<Pet> pets = petRepository.findByNameContainingOrSpeciesContaining(keyword);
        List<PetDto> result = new ArrayList<>();
        for (Pet pet : pets) {
            result.add(modelMapper.map(pet, PetDto.class));
        }
        return result;
    }

    public PetDto createPet(CreatePetRequest req) {
        Pet pet = new Pet();
        pet.setName(req.getName());
        pet.setSpecies(req.getSpecies());
        pet.setBreed(req.getBreed());
        pet.setAge(req.getAge());
        pet.setHealthInfo(req.getHealthInfo());
        pet.setId(req.getCustomerId());
        petRepository.save(pet);
        return modelMapper.map(pet, PetDto.class);
    }

    public PetDto updatePet(int id, UpdatePetRequest req) {
        Pet pet = petRepository.findById(id).orElse(null);
        if (pet == null) {
            throw new NotFoundException("Pet not found");
        }
        pet.setName(req.getName());
        pet.setSpecies(req.getSpecies());
        pet.setBreed(req.getBreed());
        pet.setAge(req.getAge());
        pet.setHealthInfo(req.getHealthInfo());
        pet.setId(req.getCustomerId());
        petRepository.save(pet);
        return modelMapper.map(pet, PetDto.class);
    }

    public void deletePet(int id) {
        Pet pet = petRepository.findById(id).orElse(null);
        if (pet == null) {
            throw new NotFoundException("Pet not found");
        }
        petRepository.delete(pet);
    }
}