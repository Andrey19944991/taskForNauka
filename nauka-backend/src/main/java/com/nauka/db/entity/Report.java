package com.nauka.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "REPORT")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @OneToOne
    private Employee employee;

    private Date date;

    private String status;

    public  Report(){}

    public Report(Date date, String status, Employee employee) {
        this.date = date;
        this.status = status;
        this.employee = employee;
    }
}
