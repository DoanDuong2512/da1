package com.duong.restful_api.repository;

import com.duong.restful_api.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT r FROM Room r WHERE UPPER(r.roomNumber) LIKE UPPER(CONCAT('%', :keyword, '%')) OR UPPER(r.size) LIKE UPPER(CONCAT('%', :keyword, '%'))")
    List<Room> findByRoomNumberContainingOrSizeContaining(@Param(value = "keyword") String keyword);
}
