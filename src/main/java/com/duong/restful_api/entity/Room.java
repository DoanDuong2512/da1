package com.duong.restful_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String roomNumber;

    private String size;

    private int pricePerNight;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;
}