package com.example.aldebaran.service;

import com.example.aldebaran.persistence.entity.UserEntity;
import com.example.aldebaran.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity save(UserEntity user) {
        return this.userRepository.save(user);
    }



}
