package com.example.adpostingrestapi.Service;

import com.example.adpostingrestapi.Model.User.User;
import com.example.adpostingrestapi.Model.User.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser (UserDto userDto);
    List<User> findAll();
    User findById(long id);
    User findByUsername(String username);
    User updateById(UserDto userDto, long id);
    void deleteById(long id);
}
