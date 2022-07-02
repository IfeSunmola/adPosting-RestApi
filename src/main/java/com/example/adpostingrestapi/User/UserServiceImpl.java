package com.example.adpostingrestapi.User;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(UserDto userDto) {
        User newUser = new User(
                userDto.getUsername(),
                userDto.getDateOfBirth(),
                userDto.getPassword()
        );
        return userRepository.save(newUser);
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
    public User findByUsername(String username) {
        return  userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new UserNotFoundException("Username", username));
    }

    @Override
    public User updateById(UserDto userDto, long id) {
        User userInDb = findById(id);

        userInDb.setUsername(userDto.getUsername());
        userInDb.setDateOfBirth(userDto.getDateOfBirth());
        userInDb.setPassword(userDto.getPassword());
        userRepository.save(userInDb);
        return userInDb;
    }

    @Override
    public void deleteById(long id) {
        findById(id);// throws exception if id was not found, below code won't execute
        userRepository.deleteById(id);
    }
}
