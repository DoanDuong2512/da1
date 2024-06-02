package com.duong.restful_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private Date registrationDate;
    private int userId;
}
