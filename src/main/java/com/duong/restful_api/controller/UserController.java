package com.duong.restful_api.controller;
import com.duong.restful_api.entity.User;
import com.duong.restful_api.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static java.lang.System.out;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private com.duong.restful_api.controller.UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListuser(){
        List<UserDto> users=userService.getListUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(name="keyword",required = false, defaultValue = "") String keyword) {
        List<UserDto> users = userService.Searchuser(keyword);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDto result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping("")
    public ResponseEntity<?> createUser(@Validated @RequestBody com.example.demo.model.request.CreateUserReq req) {
        UserDto result = userService.createUser(req);
        return ResponseEntity.ok(result);
    }}