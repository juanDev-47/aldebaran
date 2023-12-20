package com.example.aldebaran.web.controller;

import com.example.aldebaran.persistence.entity.UserEntity;
import com.example.aldebaran.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user){
        return ResponseEntity.ok(this.userService.save(user));
    }

}
