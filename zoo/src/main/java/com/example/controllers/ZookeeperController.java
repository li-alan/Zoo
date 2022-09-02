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

import com.example.models.Zookeeper;
import com.example.services.ZookeeperService;

@RestController
@RequestMapping("api/zookeeper")
public class ZookeeperController {
    @Autowired
    ZookeeperService service;

    @GetMapping("/showZookeepers")
    public List<Zookeeper> showZookeepers() {
        return service.getAll();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity <Zookeeper> getZookeeperById(@PathVariable("id") int id){
        Optional<Zookeeper> exists = service.getZookeeperByID(id);
        if(exists.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(exists.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @PostMapping("/addZookeeper")
    public ResponseEntity<Zookeeper> insert(@RequestBody Zookeeper z){
        boolean inserted = service.addZookeeper(z);
        if (inserted){
            return ResponseEntity.status(HttpStatus.CREATED).body(z);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws AttributeNotFoundException {
        Optional<Zookeeper> exists = service.getZookeeperByID(id);
        if(exists.isPresent()) {
            service.deleteZookeeperById(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted zookeeper");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PutMapping("/updateZookeeper")
    public ResponseEntity<Zookeeper> updateZookeeper(@RequestBody Zookeeper z){
        boolean updated = service.updateZookeeper(z);
        if (updated){
            return ResponseEntity.status(HttpStatus.OK).body(z);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
