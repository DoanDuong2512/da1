package com.duong.restful_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String position;
    private String phone;
    private String email;
    private Date hireDate;
    private int salary;
    private int userId;
}
