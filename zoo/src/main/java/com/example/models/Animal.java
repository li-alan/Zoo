package com.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "animals")
@Entity
public class Animal {
    @Id
    int idno;
    String name, origin;
    public Animal() {
    }
    public Animal(int idno, String name, String origin) {
        this.idno = idno;
        this.name = name;
        this.origin = origin;
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
    @Override
    public String toString() {
        return "Animal [idno=" + idno + ", name=" + name + ", origin=" + origin + "]";
    }
}
