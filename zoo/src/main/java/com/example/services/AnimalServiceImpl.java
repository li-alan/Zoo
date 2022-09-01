package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Animal;
import com.example.repos.AnimalRepo;

@Service
public class AnimalServiceImpl implements AnimalService{
    @Autowired
    AnimalRepo repo;

    @Override
    public List<Animal> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Animal> getAnimalByID(int id) {
        return repo.findById(id);
    }

    @Override
    public boolean deleteAnimalById(int id) {
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addAnimal(Animal a) {
        Optional <Animal> exist = repo.findById(a.getIdno());
        if (exist.isPresent()){
            return false;
        }
        else{
            repo.save(a);
            return true;
        }
    }

    @Override
    public boolean updateAnimal(Animal a) {
        Optional <Animal> exist = repo.findById(a.getIdno());
        if (exist.isPresent()){
            repo.save(a);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean deleteAll() {
        try {
            repo.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
