package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Zookeeper;

@Repository
public interface ZookeeperRepo extends JpaRepository<Zookeeper, Integer> {
}
