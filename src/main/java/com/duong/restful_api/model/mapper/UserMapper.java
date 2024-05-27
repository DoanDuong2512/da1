package com.duong.restful_api.model.mapper;

import com.duong.restful_api.entity.User;
import com.duong.restful_api.model.dto.UserDto;
public class UserMapper {
    public static UserDto toUserDto(User user) {
        if (user == null) {
            return null;}
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAddress(user.getAddress());
        return tmp;
    }
}
