package com.example.models;

import javax.persistence.*;

@Table(name = "zookeeper")
@Entity
public class Zookeeper {
    @Id
    int empid;
    String name;
    int salary;
    public Zookeeper(int empid, String name, int salary) {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
    }
    public Zookeeper() {
    }
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
