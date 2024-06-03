package com.duong.restful_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePetCareLogRequest {
    private int Id;
    private int pet;
    private int employee;
    private Date careDate;
    private String activity;
    private String notes;
}
