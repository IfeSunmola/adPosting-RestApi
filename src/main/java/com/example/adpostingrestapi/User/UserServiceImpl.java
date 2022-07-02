package com.example.adpostingrestapi.User;

import com.example.adpostingrestapi.User.Exceptions.InvalidParametersException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with id " + id + " was not found"));
    }

    @Override
    public User findByEmail(String email) {
        return  userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException("Username/Email '" + email + "' was not found"));
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return  userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(
                        () -> new UsernameNotFoundException("Phone number '" + phoneNumber + "' was not found"));
    }

    @Override
    public User createUser(UserRegistrationDto newUserInfo) throws InvalidParametersException {
        if (findByEmail(newUserInfo.getEmail()) != null){
            throw new InvalidParametersException(
                    UserRegistrationDto.class.getName(),
                    "email",
                    "Email has already been registered"
            );
        }

        if (findByPhoneNumber(newUserInfo.getPhoneNumber()) != null){
            throw new InvalidParametersException(
                    UserRegistrationDto.class.getName(),
                    "phoneNumber",
                    "Phone number has been linked to an account"
            );
        }
        //TODO: Set up roles
        newUserInfo.setPassword(passwordEncoder.encode(newUserInfo.getPassword()));
        return userRepository.save(new User(newUserInfo));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateById(UserDto userDto, long id) {
        User userInDb = findById(id);// throws exception if id was not found. below code won't execute

        userInDb.setFirstName(userDto.firstName());
        userInDb.setLastName(userDto.lastName());
        userInDb.setEmail(userDto.email());
        userInDb.setPhoneNumber(userDto.phoneNumber());
        userInDb.setDateOfBirth(userDto.dateOfBirth());
        userInDb.setPassword(userDto.password());
        userRepository.save(userInDb);
        return userInDb;
    }

    @Override
    public void deleteById(long id) {
        findById(id);// throws exception if id was not found. below code won't execute
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = findByEmail(email); // throws exception if id was not found. below code won't execute
        return new CustomUserDetails((user));
    }

    @Override // for testing, DELETE LATER
    public List<User> createUsers(List<UserRegistrationDto> newUsers) {
        List <User> returnList = new ArrayList<>();
        for(UserRegistrationDto user: newUsers){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            returnList.add(userRepository.save(new User(user)));
        }
        return returnList;
    }
}
