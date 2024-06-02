package com.duong.restful_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class RoomDto {
    private int id;
    private BigDecimal pricePerNight;
    private String roomNumber;
    private String size;
}
