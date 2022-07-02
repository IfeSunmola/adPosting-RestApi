package com.example.adpostingrestapi.User;

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
    public User createUser(UserRegistrationDto newUserInfo) {
        newUserInfo.setPassword(passwordEncoder.encode(newUserInfo.getPassword()));
        return userRepository.save(new User(newUserInfo));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("Id", id));
    }

    @Override
    public User findByEmail(String email) {
        return  userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new UserNotFoundException("Email", email));
    }

    @Override
    public User updateById(UserDto userDto, long id) {
        User userInDb = findById(id);

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
        findById(id);// throws exception if id was not found, below code won't execute
        userRepository.deleteById(id);
    }

    @Override // for testing
    public List<User> createUsers(List<UserRegistrationDto> newUsers) {
        List <User> returnList = new ArrayList<>();
        for(UserRegistrationDto user: newUsers){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            returnList.add(userRepository.save(new User(user)));
        }
        return returnList;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new CustomUserDetails(findByEmail(email));
    }
}
