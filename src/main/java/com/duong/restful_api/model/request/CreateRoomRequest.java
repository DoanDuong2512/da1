package com.duong.restful_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRoomRequest {
    private int pricePerNight;
    private String roomNumber;
    private String size;
}
