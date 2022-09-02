package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Assignment;
import com.example.repos.AssignmentRepo;

@Service
public class AssignmentServiceImpl implements AssignmentService{
    @Autowired
    AssignmentRepo repo;
    
    @Override
    public List<Assignment> getAll(){
        return repo.findAll();
    }

    @Override
    public Optional<Assignment> getAssignmentById(int id){
        return repo.findById(id);
    }

    @Override
    public boolean deleteAssignmentById(int id){
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addAssignment(Assignment a){
        Optional <Assignment> exist = repo.findById(a.getAsgno());
        if (exist.isPresent()){
            return false;
        }
        else{
            repo.save(a);
            return true;
        }
    }

    @Override
    public boolean updateAssignment(Assignment a){
        Optional <Assignment> exist = repo.findById(a.getAsgno());
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
