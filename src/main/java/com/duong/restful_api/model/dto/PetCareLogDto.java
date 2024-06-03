package com.duong.restful_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetCareLogDto {

    private int Id;
    private int pet;
    private int employee;
    private Date careDate;
    private String activity;
    private String notes;

}
