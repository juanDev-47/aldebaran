package com.example.aldebaran.persistence.repository;

import com.example.aldebaran.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {


}
