package com.duong.restful_api.service;

import com.duong.restful_api.entity.PetCareLog;
import com.duong.restful_api.exception.NotFoundException;
import com.duong.restful_api.model.dto.PetCareLogDto;
import com.duong.restful_api.model.request.CreatePetCareLogRequest;
import com.duong.restful_api.model.request.UpdatePetCareLogRequest;
import com.duong.restful_api.repository.PetCareLogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetCareLogService {
    @Autowired
    private PetCareLogRepository petCareLogRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PetCareLogDto> getListPetCareLogs() {
        List<PetCareLog> petCareLogs = petCareLogRepository.findAll();
        List<PetCareLogDto> result = new ArrayList<>();
        for (PetCareLog petCareLog : petCareLogs) {
            result.add(modelMapper.map(petCareLog, PetCareLogDto.class));
        }
        return result;
    }

    public PetCareLogDto getPetCareLogById(int id) {
        PetCareLog petCareLog = petCareLogRepository.findById(id).orElse(null);
        if (petCareLog == null) {
            throw new NotFoundException("Pet Care Log not found");
        }
        return modelMapper.map(petCareLog, PetCareLogDto.class);
    }

    public PetCareLogDto createPetCareLog(CreatePetCareLogRequest req) {
        PetCareLog petCareLog = new PetCareLog();
        petCareLog.setId(req.getPet());
        petCareLog.setId(req.getEmployee());
        petCareLog.setCareDate(req.getCareDate());
        petCareLog.setActivity(req.getActivity());
        petCareLog.setNotes(req.getNotes());
        petCareLogRepository.save(petCareLog);
        return modelMapper.map(petCareLog, PetCareLogDto.class);
    }

    public PetCareLogDto updatePetCareLog(int id, UpdatePetCareLogRequest req) {
        PetCareLog petCareLog = petCareLogRepository.findById(id).orElse(null);
        if (petCareLog == null) {
            throw new NotFoundException("Không tìm thấy");
        }
        petCareLog.setId(req.getPet());
        petCareLog.setId(req.getEmployee());
        petCareLog.setCareDate(req.getCareDate());
        petCareLog.setActivity(req.getActivity());
        petCareLog.setNotes(req.getNotes());
        petCareLogRepository.save(petCareLog);
        return modelMapper.map(petCareLog, PetCareLogDto.class);
    }

    public void deletePetCareLog(int id) {
        PetCareLog petCareLog = petCareLogRepository.findById(id).orElse(null);
        if (petCareLog == null) {
            throw new NotFoundException("Không tìm thấy");
        }
        petCareLogRepository.delete(petCareLog);
    }
}
