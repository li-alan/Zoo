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

import com.example.models.Assignment;
import com.example.services.AssignmentService;

@RestController
@RequestMapping("api/assignments")
public class AssignmentController {

    @Autowired
    AssignmentService service;

    @GetMapping("/showAssignments")
    public List<Assignment> showAssignments() {
        return service.getAll();
    }

    @GetMapping("/getAssignment/{id}")
    public ResponseEntity <Assignment> getAssignmentById(@PathVariable("id") int id){
        Optional<Assignment> exists = service.getAssignmentById(id);
        if(exists.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(exists.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @PostMapping("/addAssignment")
    public ResponseEntity<Assignment> insert(@RequestBody Assignment a){
        boolean inserted = service.addAssignment(a);
        if (inserted){
            return ResponseEntity.status(HttpStatus.CREATED).body(a);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws AttributeNotFoundException {
        Optional<Assignment> exists = service.getAssignmentById(id);
        if(exists.isPresent()) {
            service.deleteAssignmentById(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted assignment");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PutMapping("/updateAssignment")
    public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment a){
        boolean updated = service.updateAssignment(a);
        if (updated){
            return ResponseEntity.status(HttpStatus.OK).body(a);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    
}
