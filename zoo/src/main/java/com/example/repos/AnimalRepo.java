package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Animal;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Integer> {
    
}
