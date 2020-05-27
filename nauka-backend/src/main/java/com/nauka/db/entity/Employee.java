package com.nauka.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    private String surname;

    private String name;

    private String middle_name;

    private String position;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTab_number() {
        return tab_number;
    }

    public void setTab_number(int tab_number) {
        this.tab_number = tab_number;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    private int tab_number;

    @OneToOne
    private Department department;


    public Employee(String surname, String name, String middle_name, String position, int tab_number) {
        this.surname = surname;
        this.name = name;
        this.middle_name = middle_name;
        this.position = position;
        this.tab_number = tab_number;
    }

    public Employee(){}

}
