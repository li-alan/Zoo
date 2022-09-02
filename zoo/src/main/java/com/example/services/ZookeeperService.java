package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.models.Zookeeper;

public interface ZookeeperService {
    List<Zookeeper> getAll();
    Optional<Zookeeper> getZookeeperByID(int id);
    boolean deleteZookeeperById(int id);
    boolean addZookeeper(Zookeeper z);
    boolean updateZookeeper(Zookeeper z);
    boolean deleteAll();
}
