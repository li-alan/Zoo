package com.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "animals")
@Entity
public class Animal {
    @Id
    int idno;
    String name, origin, zookeeper;
    public Animal() {
    }
    public Animal(int idno, String name, String origin, String zookeeper) {
        this.idno = idno;
        this.name = name;
        this.origin = origin;
        this.zookeeper = zookeeper;
    }
    public int getIdno() {
        return idno;
    }
    public void setIdno(int idno) {
        this.idno = idno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getZookeeper() {
        return zookeeper;
    }
    public void setZookeeper(String zookeeper) {
        this.zookeeper = zookeeper;
    }
    @Override
    public String toString() {
        return "Animal [idno=" + idno + ", name=" + name + ", origin=" + origin + ", zookeeper=" + zookeeper + "]";
    }
}
