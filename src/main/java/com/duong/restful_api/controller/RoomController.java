package com.duong.restful_api.controller;
import com.duong.restful_api.model.dto.RoomDto;
import com.duong.restful_api.model.request.CheckAvailableRoomRequest;
import com.duong.restful_api.model.request.CreateRoomRequest;
import com.duong.restful_api.model.request.UpdateRoomRequest;
import com.duong.restful_api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("")
    public ResponseEntity<?> getListRoom() {
        List<RoomDto> rooms = roomService.getListRooms();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchRoom(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword) {
        List<RoomDto> rooms = roomService.searchRoom(keyword);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable int id) {
        RoomDto result = roomService.getRoomById(id);
        return ResponseEntity.ok(result);
    }
@PostMapping("")
public ResponseEntity<?> createRoom(@Validated @RequestBody CreateRoomRequest req) {
    RoomDto result = roomService.createRoom(req);
    return ResponseEntity.ok(result);
}
//
@PutMapping("/{id}")
public ResponseEntity<?> updateRoom(@PathVariable int id, @Validated @RequestBody UpdateRoomRequest req) {
    RoomDto result = roomService.updateRoom(id, req);
    return ResponseEntity.ok(result);
}
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteRoom(@PathVariable int id) {
    roomService.deleteRoom(id);
    return ResponseEntity.ok("Xóa thành công");
}

    @PostMapping("/available")
    public ResponseEntity<?> getAvailableRooms(CheckAvailableRoomRequest req) {
        List<RoomDto> rooms = roomService.getAvailableRooms(req.getStartDate(), req.getEndDate());
        return ResponseEntity.ok(rooms);
    }
}




