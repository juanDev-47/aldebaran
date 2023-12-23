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

    /**
     *Description: this function change de actual currency to dollars, de esta forma podemos generar la documentacion de nuestros proyectos
     *
     * @param quantity amount of money
     * @param currency type of money: only accept MXN or COP
     * @return quantity return amount of money in dollars
      */
    public UserEntity save(UserEntity user) {
        return this.userRepository.save(user);
    }



}
