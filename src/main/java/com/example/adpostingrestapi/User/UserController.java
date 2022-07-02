package com.example.adpostingrestapi.User;

import com.example.adpostingrestapi.User.Exceptions.InvalidParametersException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <User> findUserById(@PathVariable long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity <User> findUserByEmail(@RequestParam String email){
        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRegistrationDto newUserInfo, Errors errors) throws InvalidParametersException {
        if (errors.hasFieldErrors()){
            throw new InvalidParametersException(errors.getFieldErrors());
        }
        // TODO: Figure out how to confirm password with annotations in UserRegistrationDto
        if (!newUserInfo.getPassword().equals(newUserInfo.getConfirmPassword())){
            throw new InvalidParametersException(
                    UserRegistrationDto.class.getName(),
                    "password",
                    "Passwords do not match"
            );
        }
        return new ResponseEntity<>(userService.createUser(newUserInfo), HttpStatus.OK);
    }

    @PostMapping("/new-multiple")
    public ResponseEntity<List<User>> createUsers(@RequestBody List<UserRegistrationDto> newUsers){
        return new ResponseEntity<>(userService.createUsers(newUsers), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody UserDto userDto, @PathVariable long id){
        return new ResponseEntity<>(userService.updateById(userDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> deleteUser(@PathVariable long id){
        userService.deleteById(id);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }

}
