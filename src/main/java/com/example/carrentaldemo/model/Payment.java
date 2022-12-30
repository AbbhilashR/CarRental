package com.example.carrentaldemo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="payment")
class Payment{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long paymentid;

    @OneToOne
    @JoinColumn(name="bookingid",referencedColumnName="bookingid")
    private Booking booking;

    @Column(name="totalamount",nullable=false)
    private int totalamount;

    @Column(name="advanceamount",nullable=false)
    private int advanceamount;

    @Column(name="paymenttype",nullable=false)
    private String paymenttype;

    @Column(name="remainingamount",nullable=false)
    private int remainingamount;

}

