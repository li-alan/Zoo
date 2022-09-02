package com.example.controllers;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Animal;
import com.example.services.AnimalService;

@RestController
@RequestMapping("api/animal")
public class AnimalController {
    @Autowired
    AnimalService service;

    @GetMapping("/showAnimals")
    public List<Animal> showAnimals() {
        return service.getAll();
    }
    @GetMapping("/getAnimal/{id}")
    public ResponseEntity <Animal> getAnimalById(@PathVariable("id") int id){
        Optional<Animal> exists = service.getAnimalByID(id);
        if(exists.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(exists.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @PostMapping("/manager/addAnimal")
    public ResponseEntity<Animal> insert(@RequestBody Animal a){
        boolean inserted = service.addAnimal(a);
        if (inserted){
            return ResponseEntity.status(HttpStatus.CREATED).body(a);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/manager/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws AttributeNotFoundException {
        Optional<Animal> exists = service.getAnimalByID(id);
        if(exists.isPresent()) {
            service.deleteAnimalById(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted animal");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PutMapping("/manager/updateAnimal")
    public ResponseEntity<Animal> updateAnimal(@RequestBody Animal a){
        boolean updated = service.updateAnimal(a);
        if (updated){
            return ResponseEntity.status(HttpStatus.OK).body(a);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
