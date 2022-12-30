package com.example.carrentaldemo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="cancellation")
public class Cancellation{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long cancellationid;

    @OneToOne
    @JoinColumn(name="bookingid",referencedColumnName="bookingid")
    private Booking booking;

    @Column(name="cancellationdate",nullable=false)
    private String cancellationdate;

    @Column(name="cancellationtime",nullable=false)
    private String cancellationtime;

    @Column(name="cancellationreason",nullable=false)
    private String cancellationreason;

}