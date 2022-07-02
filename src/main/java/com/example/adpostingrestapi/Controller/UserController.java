package com.example.adpostingrestapi.Controller;

import com.example.adpostingrestapi.Model.User.User;
import com.example.adpostingrestapi.Model.User.UserDto;
import com.example.adpostingrestapi.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    /*
    * Get all users
    * localhost:8080/users/all
    * */
    @GetMapping("/all")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    /*
     * Get user with id
     * localhost:8080/users/[id]
     * localhost:8080/users/3
     * */
    @GetMapping("/{id}")
    public ResponseEntity <User> findUserById(@PathVariable long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    /*
     * Get user with username
     * localhost:8080/users?username=[username]
     * localhost:8080/users?username=James
     * */
    @GetMapping()
    public ResponseEntity <User> findUserByUsername(@RequestParam String username){
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

    // create user
    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
    }

    // update user
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