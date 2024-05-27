package com.duong.restful_api.service;

import com.duong.restful_api.entity.User;
import com.duong.restful_api.exception.NotFoundException;
import com.duong.restful_api.model.dto.UserDto;
import com.duong.restful_api.model.mapper.UserMapper;
import com.duong.restful_api.model.request.CreateUserRequest;
import com.duong.restful_api.model.request.UpdateUserRequest;
import com.duong.restful_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getListUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException("Khong thay");
        }
        return UserMapper.toUserDto(user);
    }

    public List<UserDto> searchUser(String keyword) {
        List<User> users = userRepository.findByNameContaining(keyword);
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    public UserDto createUser(CreateUserRequest req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setAddress(req.getAddress());
        user.setPassword(req.getPassword());
        userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    public UserDto updateUser(int id, UpdateUserRequest req) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException("Khong thay");
        }
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setAddress(req.getAddress());
        user.setPassword(req.getPassword());
        userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException("Khong thay");
        }
        userRepository.delete(user);
    }
}
