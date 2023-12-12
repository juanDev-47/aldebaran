package com.example.aldebaran.web.controller;

import com.example.aldebaran.persistence.entity.CustomerEntity;
import com.example.aldebaran.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity> getByPhone(@PathVariable String phone){
        return ResponseEntity.ok(this.customerService.findByPhone(phone));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CustomerEntity> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.customerService.findByName(name));
    }

}
