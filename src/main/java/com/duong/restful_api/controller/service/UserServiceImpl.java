package com.duong.restful_api.controller.service;
import com.duong.restful_api.controller.UserService;
import com.duong.restful_api.entity.User;
import com.duong.restful_api.exception.NotFoundException;
import com.duong.restful_api.model.dto.UserDto;
import com.duong.restful_api.model.mapper.UserMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component

public class UserServiceImpl implements UserService {

 private static ArrayList<User> users = new ArrayList<User>();
 static {
  users.add(new User(1,"duong","f","f","F","wwww"));
  users.add(new User(2,"tduong","f","f","F","wwww"));
  users.add(new User(3,"dduong","f","f","F","wwww"));
  users.add(new User(4,"zduong","f","f","F","wwww"));
  users.add(new User(5,"ddtduong","f","f","F","wwww"));
 }

 private String keyword;

 @Override
 public List<UserDto> getListUsers() {
  List<UserDto> result = new ArrayList<UserDto>();
  for (User user : users) {
   result.add(UserMapper.toUserDto(user));
  }
  return result;
 }
// lấy theo id
 @Override
 public UserDto getUserById(int id) {
  for (User user : users) {
   if (user.getId() == id) {
    return UserMapper.toUserDto(user);
   }
  }
  throw new NotFoundException("deo thay");
 }
 //tìm kím
  @Override
  public List<UserDto> Searchuser(String keyword) {
   List<UserDto> result = new ArrayList<>();
   for (User user : users) {
    if (user.getName().contains(keyword)) {
     result.add(UserMapper.toUserDto(user));
    }
   }
   return result;
  }
 @Override
 public UserDto CreateUserReq(CreateUserReq req) {
  for (User user : users) {
   if (user.getEmail().equals(req.getEmail())) {
    throw new com.example.demo.exception.DuplicateRecordException("trung emao");
   }
  }
  User user = UserMapper.toUser(req);
  user.setId(users.size()+1);
  users.add(user);
  return UserMapper.toUserDto(user);
 }

}


