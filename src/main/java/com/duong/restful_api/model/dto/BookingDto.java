package com.duong.restful_api.model.dto;

import com.duong.restful_api.entity.Customer;
import com.duong.restful_api.entity.Pet;
import com.duong.restful_api.entity.Room;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookingDto {

    private int id;

    private Date checkInDate;

    private Date checkOutDate;

    private BigDecimal totalPrice;

    private String cameraLink;

    private CustomerDto customer;

    private RoomDto room;

    private PetDto pet;
}
