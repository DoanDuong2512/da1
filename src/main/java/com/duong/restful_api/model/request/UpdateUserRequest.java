package com.duong.restful_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserRequest {
    private int id ;
    private String name ;
    private String email ;
    private String phone ;
    private String address ;
    private String password ;
}