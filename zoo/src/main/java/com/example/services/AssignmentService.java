package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.models.Assignment;

public interface AssignmentService {
    List<Assignment> getAll();
    Optional<Assignment> getAssignmentById(int id);
    boolean deleteAssignmentById(int id);
    boolean addAssignment(Assignment a);
    boolean updateAssignment(Assignment a);
    boolean deleteAll();
}
