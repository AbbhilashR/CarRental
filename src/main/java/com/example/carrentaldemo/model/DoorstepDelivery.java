package com.example.carrentaldemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="doorstepdelivery")
public class DoorstepDelivery {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long doorstepdeliveryid;

    @Column(name="deliverylocation",nullable=false)
    private String deliverylocation;

    @Column(name="deliverydate",nullable=false)
    private String deliverydate;

    @OneToOne
    @JoinColumn(name="bookingid",referencedColumnName="bookingid")
    private Booking booking;



}