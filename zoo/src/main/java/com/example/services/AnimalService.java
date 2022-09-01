package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.models.Animal;

public interface AnimalService {
    List<Animal> getAll();
    Optional<Animal> getAnimalByID(int id);
    boolean deleteAnimalById(int id);
    boolean addAnimal(Animal a);
    boolean updateAnimal(Animal a);
    boolean deleteAll();
}
