package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Zookeeper;
import com.example.repos.ZookeeperRepo;

@Service
public class ZookeeperServiceImpl implements ZookeeperService{
    @Autowired
    ZookeeperRepo repo;

    @Override
    public List<Zookeeper> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Zookeeper> getZookeeperByID(int id) {
        return repo.findById(id);
    }

    @Override
    public boolean deleteZookeeperById(int id){
        try {
            repo.deleteById(id); 
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addZookeeper(Zookeeper z) {
        Optional <Zookeeper> exists = repo.findById(z.getEmpid());
        if(exists.isPresent()){
            return false;
        }
        else {
            repo.save(z);
            return true;
        }
    }

    @Override
    public boolean updateZookeeper(Zookeeper z) {
        Optional <Zookeeper> exists = repo.findById(z.getEmpid());
        if(exists.isPresent()){
            repo.save(z);
            return true;
        }
        else {
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
