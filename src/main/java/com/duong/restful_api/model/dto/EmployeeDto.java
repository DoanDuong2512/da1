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
public class EmployeeDto {

    private int Id;
    private String firstName;
    private String lastName;
    private String position;
    private String phone;
    private String email;
    private Date hireDate;
    private int salary;
    private int userId;

}
