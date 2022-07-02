package com.example.adpostingrestapi.User;

import com.example.adpostingrestapi.User.User;
import com.example.adpostingrestapi.User.UserDto;
import com.example.adpostingrestapi.User.UserService;
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

    @GetMapping("/all")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <User> findUserById(@PathVariable long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity <User> findUserByUsername(@RequestParam String username){
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
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
