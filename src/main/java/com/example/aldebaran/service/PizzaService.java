package com.example.aldebaran.service;

import com.example.aldebaran.persistence.entity.PizzaEntity;
import com.example.aldebaran.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final JdbcTemplate jdbcTemplate;
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(JdbcTemplate jdbcTemplate, PizzaRepository pizzaRepository){
        this.jdbcTemplate = jdbcTemplate;
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll(){
        return jdbcTemplate.query("SELECT * FROM pizza", new BeanPropertyRowMapper<>(PizzaEntity.class));
    }

}
