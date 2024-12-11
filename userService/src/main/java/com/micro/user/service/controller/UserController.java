package com.micro.user.service.controller;

import com.micro.user.service.entities.User;
import com.micro.user.service.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getById(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("user deleted with  provided id " + userId);
    }

    //update end point to be implemented yet
@PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable String userId){
        return new ResponseEntity<>(userService.updateUser(user,userId),HttpStatus.OK);
    }

}
