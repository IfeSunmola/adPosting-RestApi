package com.example.adpostingrestapi.User;

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
