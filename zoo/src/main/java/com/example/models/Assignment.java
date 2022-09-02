package com.example.models;

import javax.persistence.*;

@Table(name = "assignments")
@Entity
public class Assignment {
    @Id
    int asgno;
    int animalid, empid;
    public Assignment() {
    }
    public Assignment(int asgno, int animalid, int empid) {
        this.asgno = asgno;
        this.animalid = animalid;
        this.empid = empid;
    }
    public int getAsgno() {
        return asgno;
    }
    public void setAsgno(int asgno) {
        this.asgno = asgno;
    }
    public int getAnimalid() {
        return animalid;
    }
    public void setAnimalid(int animalid) {
        this.animalid = animalid;
    }
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    @Override
    public String toString() {
        return "Assignment [animalid=" + animalid + ", asgno=" + asgno + ", empid=" + empid + "]";
    }
}
