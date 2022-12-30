package com.example.carrentaldemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="manual_pickup")
public class ManualPickup{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long manualpickupid;

    @OneToOne
    @JoinColumn(name="bookingid",referencedColumnName="bookingid")
    private Booking booking;

    @Column(name="pickuplocation",nullable=false)
    private String pickuplocation;

    @Column(name="pickupdate",nullable=false)
    private String pickupdate;

    @Column(name="pickuptime",nullable=false)
    private String pickuptime;

    @Column(name="droplocation",nullable=false)
    private String droplocation;

    @Column(name="dropdate",nullable=false)
    private String dropdate;

}