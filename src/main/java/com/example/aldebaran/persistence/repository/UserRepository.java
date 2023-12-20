package com.example.aldebaran.persistence.repository;

import com.example.aldebaran.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity, String> {
}
