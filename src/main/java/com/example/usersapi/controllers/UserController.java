package com.example.usersapi.controllers;

import com.example.usersapi.models.UserModel;
import com.example.usersapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ArrayList<UserModel> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping( path = "/findById/{id}")
    public Optional<UserModel> getUserByiD(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping("/createOrUpdate")
    public UserModel createOrUpdateUser(@RequestBody UserModel user) {
        return userService.createOrUpdate(user);
    }

    @DeleteMapping( path = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.delete(id);
        if (ok){
            return "User with Id: " + id + " was deleted";
        }else{
            return "Can't delete user with Id: " + id;
        }
    }
}
