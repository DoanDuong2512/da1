package com.duong.restful_api.service;

import com.duong.restful_api.entity.Room;
import com.duong.restful_api.exception.NotFoundException;
import com.duong.restful_api.model.dto.RoomDto;
import com.duong.restful_api.model.request.CreateRoomRequest;
import com.duong.restful_api.model.request.UpdateRoomRequest;
import com.duong.restful_api.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<RoomDto> getListRooms() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomDto> result = new ArrayList<>();
        for (Room room : rooms) {
            result.add(modelMapper.map(room, RoomDto.class));
        }
        return result;
    }

    public RoomDto getRoomById(int id) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room == null) {
            throw new NotFoundException("Không tìm thấy phòng");
        }
        return modelMapper.map(room, RoomDto.class);
    }

    public List<RoomDto> searchRoom(String keyword) {
        List<Room> rooms = roomRepository.findByRoomNumberContainingOrSizeContaining(keyword);
        List<RoomDto> result = new ArrayList<>();
        for (Room room : rooms) {
            result.add(modelMapper.map(room, RoomDto.class));
        }
        return result;
    }

    public RoomDto createRoom(CreateRoomRequest req) {
        Room room = new Room();
        room.setRoomNumber(req.getRoomNumber());
        room.setSize(req.getSize());
        room.setPricePerNight(req.getPricePerNight());
        roomRepository.save(room);
        return modelMapper.map(room, RoomDto.class);
    }

    public RoomDto updateRoom(int id, UpdateRoomRequest req) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room == null) {
            throw new NotFoundException("Không tìm thấy phòng");
        }
        room.setRoomNumber(req.getRoomNumber());
        room.setSize(req.getSize());
        room.setPricePerNight(req.getPricePerNight());
        roomRepository.save(room);
        return modelMapper.map(room, RoomDto.class);
    }

    public void deleteRoom(int id) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room == null) {
            throw new NotFoundException("Không tìm thấy phòng");
        }
        roomRepository.delete(room);
    }

    public List<RoomDto> getAvailableRooms(LocalDateTime startDate, LocalDateTime endDate) {
        List<Room> rooms = roomRepository.findAvailableRooms(startDate, endDate);
        List<RoomDto> result = new ArrayList<>();
        for (Room room : rooms) {
            result.add(modelMapper.map(room, RoomDto.class));
        }
        return result;
    }
}
