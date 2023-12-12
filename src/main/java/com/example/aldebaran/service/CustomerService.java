package com.example.aldebaran.service;

import com.example.aldebaran.persistence.entity.CustomerEntity;
import com.example.aldebaran.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerEntity findByPhone(String phone){
        return this.customerRepository.findByPhone(phone);
    }

    public CustomerEntity findByName(String name){
        return this.customerRepository.findByName(name);
    }

}
