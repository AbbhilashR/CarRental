package com.example.carrentaldemo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


@Data
@Entity
@Table(name="booking")
public class Booking{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long bookingid;

    @ManyToOne
    @JoinColumn(name="carid",referencedColumnName="carid")
    private Car car;

    @ManyToOne
    @JoinColumn(name="userid",referencedColumnName="userid")
    private User user;

    @Column(name="bookingdate",nullable=false)
    private Timestamp bookingdate;

    @Column(name="returndate",nullable=false)
    private Timestamp returndate;

    @Column(name="Extratime",nullable=false)
    private Timestamp extratime;

    @OneToOne(mappedBy="booking")
    private Payment payment;

    @OneToOne(mappedBy="booking")
    private Rating rating;

    @OneToOne(mappedBy="booking")
    private ManualPickup manualpickup;


    @OneToOne(mappedBy="booking")
    private DoorstepDelivery doorstep_delivery;

    @OneToOne(mappedBy="booking")
    private Cancellation cancellation;
}