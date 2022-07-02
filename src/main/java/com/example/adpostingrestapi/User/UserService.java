package com.example.adpostingrestapi.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    User createUser (UserRegistrationDto newUserInfo);
    List<User> findAll();
    User findById(long id);
    User findByEmail(String email);
    User updateById(UserDto userDto, long id);
    void deleteById(long id);
    List<User> createUsers(List<UserRegistrationDto> newUsers);
}
