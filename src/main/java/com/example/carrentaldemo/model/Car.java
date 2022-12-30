package com.example.carrentaldemo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="car")
public class Car{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long carid;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="userid",referencedColumnName="userid")
    private User user;

    @Column(name="carmake",nullable=false)
    private String carmake;

    @Column(name="carmodel",nullable=false)
    private String carmodel;

    @Column(name="price",nullable=false)
    private int price;

    @Column(name="insurance",nullable=false)
    private int insurance;

    @Column(name="rcbook",nullable=false)
    private String rcbook;

    @Column(name="ismanual",nullable=false)
    private boolean ismanual;

    @Column(name="kmsdriven",nullable=false)
    private int kmsdriven;

    @Column(name="fueltype",nullable=false)
    private String fueltype;

    @Column(name="seats",nullable=false)
    private int seats;

    @Column(name="mileage",nullable=false)
    private int mileage;

    @OneToMany(mappedBy="car")
    private Set<Booking> booking;

}