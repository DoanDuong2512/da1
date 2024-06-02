package com.duong.restful_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRoomRequest {
    private int pricePerNight;
    private String roomNumber;
    private String size;

    // Getters and Setters
}
