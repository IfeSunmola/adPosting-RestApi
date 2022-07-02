package com.example.adpostingrestapi.User;

import com.example.adpostingrestapi.User.Exceptions.InvalidParametersException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    User createUser(UserRegistrationDto newUserInfo) throws InvalidParametersException;

    List<User> findAll();

    User findById(long id);

    User findByEmail(String email);

    User findByPhoneNumber (String phoneNumber);

    User updateById(UserDto userDto, long id);

    void deleteById(long id);

    List<User> createUsers(List<UserRegistrationDto> newUsers);
}
