package com.duong.restful_api.controller;

import com.duong.restful_api.model.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getListUsers();

    public UserDto getUserById(int id) ;

    public  List<UserDto> Searchuser(String keyword);

    public UserDto createUser(CreateUserReq req);

}
